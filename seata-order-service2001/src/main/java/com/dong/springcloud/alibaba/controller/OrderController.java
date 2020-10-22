package com.dong.springcloud.alibaba.controller;


import com.dong.springcloud.alibaba.domain.CommonResult;
import com.dong.springcloud.alibaba.domain.Order;
import com.dong.springcloud.alibaba.service.Orderservice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private Orderservice orderservice;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderservice.create(order);
        return new CommonResult(200,"订单创建成功");
    }

}
