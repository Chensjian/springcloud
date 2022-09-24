package com.chen.springcloud.service.impl;

import com.chen.springcloud.service.IMessageProvider;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author chenchenchen
 * @create 2022-09-17 14:33
 */
@Service
public class IMessageProviderImpl implements IMessageProvider {
    @Autowired
    private StreamBridge streamBridge;


    public String send() {
        String serial = UUID.randomUUID().toString();
        streamBridge.send("myGroup-out-0", serial);
        System.out.println("发送消息:"+serial);

        return null;
    }
}
