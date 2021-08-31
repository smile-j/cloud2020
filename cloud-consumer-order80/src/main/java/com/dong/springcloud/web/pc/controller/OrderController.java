package com.dong.springcloud.web.pc.controller;

import com.dong.springcloud.entities.CommonResult;
import com.dong.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/payment/save")
    public CommonResult<Payment> create(@RequestBody  Payment payment){
//        return restTemplate.postForObject(payment_url+"/payment/savePayment",payment,CommonResult.class);
        return restTemplate.postForEntity(payment_url+"/payment/savePayment",payment,CommonResult.class).getBody()  ;
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> findPayment(@PathVariable("id") Long id){
//        return restTemplate.getForObject(payment_url+"/payment/get/"+id,CommonResult.class);
        return restTemplate.getForEntity(payment_url+"/payment/get/"+id,CommonResult.class).getBody();
    }
    @GetMapping("/getForEntity/{id}")
    public CommonResult<Payment> findPayment2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(payment_url+"/payment/get/"+id,CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommonResult<>(444,"操作失败");
        }
    }

}
