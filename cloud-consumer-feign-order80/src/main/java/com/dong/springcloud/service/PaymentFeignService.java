package com.dong.springcloud.service;

import com.dong.springcloud.entities.CommonResult;
import com.dong.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @PostMapping("/payment/savePayment")
    public CommonResult<Integer> savePayment(@RequestBody Payment payment);
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> findById(@PathVariable("id") Long id);

    @GetMapping("/payment/lb")
    public String getPaymentLB();

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut();
}
