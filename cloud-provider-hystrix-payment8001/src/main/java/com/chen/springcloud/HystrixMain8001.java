package com.chen.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

/**
 * @author chenchenchen
 * @create 2022-09-03 16:36
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class HystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixMain8001.class,args);
    }
    /**
     * 此配置是为了服务监控而配置，于服务容错本身无关，springcloud升级后的坑
     * ServletRegistrationBean因为springboot的默认路径而不是"/hystrix.stream"
     * 只要在自己的项目里配置下面的servlet就可以
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet hystrixMetricsStreamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(hystrixMetricsStreamServlet);
        servletRegistrationBean.setLoadOnStartup(1);
        servletRegistrationBean.addUrlMappings("/hystrix.stream");
        servletRegistrationBean.setName("HystrixMetricsStreamServlet");
        return servletRegistrationBean;
    }
}
