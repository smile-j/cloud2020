package com.dong.springcloud.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class PaymentFallBackHystrixService implements PaymentHystrixService{
    @Override
    public String paymentInfo_ok(Integer id) {
        return "-----PaymentHystrixService--fall back   paymentInfo_ok---error";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "-----PaymentHystrixService--fall back   paymentInfo_timeout---error";
    }
}
