package com.dong.springcloud.entity;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/19
 */
//@Data
//@Component
public class TestBenPostProcess implements BeanPostProcessor, InitializingBean {

    private ApplicationContext applicationContext;


    private String name;
    private Integer age;

    public TestBenPostProcess(){
        System.out.println("------TestBenPostProcess--------init-----------");
    }

    public TestBenPostProcess(String name,Integer age){
        this.name = name;
        this.age = age;
        System.out.println("------TestBenPostProcess--------init-----------");
    }

     @Override
     public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
         System.out.println("--BeanPostProcessor--postProcessBeforeInitialization---"+beanName+"===="+bean);

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof TestBenPostProcess){
            System.out.println("--BeanPostProcessor--postProcessAfterInitialization---"+beanName+"===="+bean);
        }
        return bean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("--InitializingBean--afterPropertiesSet---");
    }

    @PostConstruct
    public void postMethod(){
        System.out.println("-----TestBenPostProcess---postMethod--------");
    }
}
