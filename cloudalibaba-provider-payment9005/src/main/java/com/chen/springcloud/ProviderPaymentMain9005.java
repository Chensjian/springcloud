package com.chen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenchenchen
 * @create 2022-09-28 11:17
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPaymentMain9005 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentMain9005.class,args);
    }
}
