package com.dong.springcloud.service.impl;

import com.dong.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

@EnableBinding(Source.class)//定义消息的推送管道
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    @Autowired
    private MessageChannel output;//消息发送管道

    @Override
    public String send(String message) {
        String serial = "_"+UUID.randomUUID().toString();
        Boolean result = output.send(MessageBuilder.withPayload(serial).build());
        log.info(result+"****serial:"+serial);
        return null;
    }
}
