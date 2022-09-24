package com.chen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author chenchenchen
 * @create 2022-09-17 18:47
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitMQConsumerMain8802 {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitMQConsumerMain8802.class,args);
    }
}
