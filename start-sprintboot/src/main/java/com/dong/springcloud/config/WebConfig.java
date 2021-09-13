package com.dong.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/9/11
 */
@Configuration( proxyBeanMethods = false)
public class WebConfig /*implements WebMvcConfigurer */{
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
        methodFilter.setMethodParam( "_m" );
        return methodFilter;
    }
        // @Bean webMvcConfigurer
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper( );
                //不移除;后面的内容。矩阵变量功能就可以生戏
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }
        };
    }
       /* @Override
        public void configurePathMatch(PathMatchConfigurer configurer){
            UrlPathHelper urlPathHelper = new UrlPathHelper( );
            //不移除;后面的内容。矩阵变量功能就可以生戏
            urlPathHelper.setRemoveSemicolonContent(false);
            configurer.setUrlPathHelper(urlPathHelper);
        }*/
    }

