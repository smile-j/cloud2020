package com.dong.springcloud.web.controller;

import com.dong.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SendMessageController {

    @Autowired
    private IMessageProvider iMessageProvider;


    @GetMapping("/sendMessage")
    public String sendMessage(String msg){
        log.info("**********"+msg);
        return iMessageProvider.send(msg);
    }
}
