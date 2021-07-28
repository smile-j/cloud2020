package com.dong.springcloud.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/16
 */
//@Configuration
//@EnableSwagger2
//@EnableSwaggerBootstrapUI
public class SwaggerConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath*:/META-INF/resources/","classpath*:/META-INF/resources/webjars/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath*:/META-INF/resources/webjars/");
    }

}
