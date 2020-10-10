package com.dong.springcloud.controller;

import com.dong.springcloud.entities.CommonResult;
import com.dong.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer/order")
@Slf4j
public class OrderController {

    @Value("${paymentUrl}")
    private String payment_url;

    @Autowired
    private RestTemplate restTemplate ;

    @GetMapping("/consul")
    public String findPayment(){
        return restTemplate.getForObject(payment_url+"/payment/consul/",String.class);
    }

}
