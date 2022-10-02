package com.chen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenchenchen
 * @create 2022-09-28 10:26
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPaymentMain9003 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentMain9003.class,args);
    }
}
