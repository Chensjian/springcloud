package com.chen.springcloud.controller;

import cn.hutool.core.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;


/**
 * @author chenchenchen
 * @create 2022-09-17 18:49
 */
@Component
@Slf4j
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @Bean
    public Consumer<String> send(){
        return s -> {
            System.out.println("我是消费者"+serverPort+"我收到消息："+s);
        };
    }

}
