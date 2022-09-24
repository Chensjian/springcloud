package com.chen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenchenchen
 * @create 2022-09-22 15:54
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(NacosProviderMain9002.class,args);
    }
}
