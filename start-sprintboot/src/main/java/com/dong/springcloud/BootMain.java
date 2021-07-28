package com.dong.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/7
 */
@SpringBootApplication
@EnableAsync
public class BootMain {

    public static void main(String[] args) {

        SpringApplication.run(BootMain.class,args);

    }

}
