package com.chen.springcloud;

import com.alibaba.cloud.seata.feign.SeataFeignClientAutoConfiguration;
import com.alibaba.cloud.seata.rest.SeataRestTemplateAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

/**
 * @author chenchenchen
 * @create 2022-10-01 16:22
 */

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(exclude = {SeataFeignClientAutoConfiguration.class, SeataRestTemplateAutoConfiguration.class})
public class SeataServiceMain2001 {
    public static void main(String[] args) {
        SpringApplication.run(SeataServiceMain2001.class,args);
    }
}
