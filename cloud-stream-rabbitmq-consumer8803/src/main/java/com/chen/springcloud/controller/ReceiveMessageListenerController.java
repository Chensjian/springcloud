package com.chen.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * @author chenchenchen
 * @create 2022-09-17 19:20
 */
@Component
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @Bean
    public Consumer<String> send(){
        return s->{
            System.out.println("我是消费者"+serverPort+"我收到消息："+s);
        };
    }
}
