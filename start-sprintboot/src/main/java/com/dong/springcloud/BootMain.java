package com.dong.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/7
 */
@ComponentScan("")
@SpringBootApplication(scanBasePackageClasses = "")
@EnableAsync
@Slf4j
public class BootMain {

    public static void main(String[] args) {

        //1.返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(BootMain.class, args);

        //2.查看所有的bean组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String name:beanDefinitionNames){
            log.info("------,{}",name);
        }

    }

}
