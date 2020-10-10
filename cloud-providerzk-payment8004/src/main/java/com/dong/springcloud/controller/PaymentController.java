package com.dong.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("zk")
    public String paymentzk(){
        return "springcloud with zookeeper " + serverPort +"\t" +UUID.randomUUID().toString();
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
}
