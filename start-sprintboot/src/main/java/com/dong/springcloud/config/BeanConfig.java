package com.dong.springcloud.config;

import com.dong.springcloud.entity.TestBenPostProcess;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/19
 */
//@Configuration
public class BeanConfig {


    @Bean
    public TestBenPostProcess getTestBeanPostProcess(){
        return new TestBenPostProcess("Lili",11);

    }
}
