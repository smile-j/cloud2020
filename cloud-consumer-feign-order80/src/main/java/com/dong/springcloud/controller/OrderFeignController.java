package com.dong.springcloud.controller;

import com.dong.springcloud.entities.CommonResult;
import com.dong.springcloud.entities.Payment;
import com.dong.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consumer")
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;


    @PostMapping("/save")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        return paymentFeignService.savePayment(payment);
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> findPayment(@PathVariable("id") Long id){
        return paymentFeignService.findById(id);
    }

    @GetMapping("/lb")
    public String getPaymentLB(){
        return paymentFeignService.getPaymentLB();
    }

    @GetMapping("feign/timeout")
    public String paymentFeignTimeOut(){
        return paymentFeignService.paymentFeignTimeOut();
    }
}
