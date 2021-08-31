package com.dong.springcloud.web.pc.controller;

import com.dong.springcloud.entities.CommonResult;
import com.dong.springcloud.entities.Payment;
import com.dong.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String servertPort;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/savePayment")
    public CommonResult<Integer> savePayment(@RequestBody Payment payment){

        int num = paymentService.savePayment(payment);
        log.info(servertPort+ " *****插入结果："+num);//
        if(num>0){
            return new CommonResult(200,"SUCCESS "+servertPort,payment);
        }else {
            return new CommonResult(400,"ERROR "+servertPort,null);
        }

    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> findById(@PathVariable("id") Long id){
        log.info(servertPort +" *****查询参数："+id);//fff
        Payment payment =  paymentService.findById(id);
        if(payment!=null){
            return new CommonResult(200,"SUCCESS "+servertPort,payment);
        }else {
            return new CommonResult(400,"ERROR "+servertPort,null);
        }

    }

    @GetMapping("/discovery")
    public Object discovery(){
        List<String> service = discoveryClient.getServices();
        for (String e:service){
            log.info("*******element:"+e);
        }

       List<ServiceInstance>instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        for(ServiceInstance instance:instances){
            log.info(instance.getServiceId()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return discoveryClient;

    }

    @GetMapping("/lb")
    public String getPaymentLB(){
        return servertPort;
    }

    @GetMapping("feign/timeout")
    public String paymentFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return servertPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }

}
