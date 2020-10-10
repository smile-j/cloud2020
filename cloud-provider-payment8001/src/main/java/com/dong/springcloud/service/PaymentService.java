package com.dong.springcloud.service;

import com.dong.springcloud.entities.CommonResult;
import com.dong.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface PaymentService {

    public int savePayment(Payment payment);
    public Payment findById(Long id);

}
