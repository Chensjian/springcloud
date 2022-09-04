package com.chen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author chenchenchen
 * @create 2022-09-03 15:17
 */
@SpringBootApplication
@EnableFeignClients
public class OpenfeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OpenfeignMain80.class,args);
    }
}
