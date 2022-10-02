package com.chen.springcloud;

import com.alibaba.cloud.seata.feign.SeataFeignClientAutoConfiguration;
import com.alibaba.cloud.seata.rest.SeataRestTemplateAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author chenchenchen
 * @create 2022-10-02 10:23
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(exclude = {SeataRestTemplateAutoConfiguration.class, SeataFeignClientAutoConfiguration.class})
public class SeataStorageMain2003 {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorageMain2003.class,args);
    }
}
