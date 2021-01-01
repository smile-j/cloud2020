package com.dong.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3366 {


    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3366.class,args);
    }

}
