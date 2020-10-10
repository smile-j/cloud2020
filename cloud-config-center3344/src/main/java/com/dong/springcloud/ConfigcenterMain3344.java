package com.dong.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigcenterMain3344 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigcenterMain3344.class,args);
    }
}
