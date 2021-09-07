package com.dong.springcloud.config;

import com.dong.springcloud.entity.LogInfo;
import com.dong.springcloud.entity.Pet;
import com.dong.springcloud.entity.TestBenPostProcess;
import com.dong.springcloud.entity.UserEntity;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

/**
 * 1) @Configuration:
 *   proxyBeanMethods:true  spring创建的对象单例
 *     Full proxyBeanMethods = true
 *     Lite proxyBeanMethods = false
 * 2) @Import({UserEntity.class})
 *    给容器中自动创建这一类型的组件，默认组件的名字是全类名
 * 3) @Conditional  条件注入
 * 4)  @ImportResource 导入xml配置的bean的注入
 * 5）@EnableConfigurationProperties
 *  //.1、开启Car配置绑定功能
 *  //2、把这个car这个组件自动注测到容器中
 *
 */
@Import({UserEntity.class, LogInfo.class})
@Configuration(proxyBeanMethods = false)
//@ConditionalOnBean(name = "tom")
@ConditionalOnMissingBean(name = "tom")
@ImportResource(locations = "classpath:beans.xml")
@EnableConfigurationProperties(CarInfo.class)
public class BeanConfig {


   /* @Bean
    public TestBenPostProcess getTestBeanPostProcess(){
        return new TestBenPostProcess("Lili",11);

    }*/


//    @ConditionalOnBean(name = "tom")
    @Bean
//    @ConditionalOnClass(value = {Pet.class})
    public UserEntity user01(){
        return new UserEntity();
    }

    @Bean("tom22")
    public Pet pet01(){
        return new Pet("lala",12.2D);
    }
}
