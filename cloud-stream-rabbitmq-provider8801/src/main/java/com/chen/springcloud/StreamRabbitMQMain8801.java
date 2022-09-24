package com.chen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author chenchenchen
 * @create 2022-09-17 14:22
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitMQMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitMQMain8801.class,args);
    }
}
