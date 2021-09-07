package com.dong.springcloud;

import com.dong.springcloud.config.BeanConfig;
import com.dong.springcloud.entity.Pet;
import com.dong.springcloud.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/7
 */
//@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.dong.springcloud")
@EnableAsync
@Slf4j
public class BootMain {


    public static void main(String[] args) {

        //1.返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(BootMain.class, args);

        //2.查看所有的bean组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String name:beanDefinitionNames){
            log.info("------>>,{}",name);
        }
       /* Pet pet01 = run.getBean("pet01", Pet.class);
        Pet pet02 = run.getBean( Pet.class);
        BeanConfig bean = run.getBean(BeanConfig.class);
        Pet pet = bean.pet01();
        Pet pet1 = bean.pet01();
        System.out.println(pet01==pet02);
        System.out.println(pet==pet1);
        System.out.println(pet1==pet02);
        System.out.println(bean);
        System.out.println("---------------------------");
        String[] beanNamesForType = run.getBeanNamesForType(UserEntity.class);
        for (String str:beanNamesForType){
            System.out.println(str);
        }
        UserEntity bean1 = run.getBean(UserEntity.class);
        System.out.println(bean1);*/
        System.out.println(run.containsBean("tom22"));
//        System.out.println(run.containsBean("getTestBeanPostProcess"));
        System.out.println(run.containsBean("user01"));
    }

}
