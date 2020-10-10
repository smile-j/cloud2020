package com.dong.springcloud.controller;

import com.dong.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("consumer/order")
public class OrderController {

    @Value("${paymentUrl}")
    private String payment_url;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/zk")
    public String getZk(){
        return restTemplate.getForObject(payment_url+"/payment/zk", String.class);
    }

}
