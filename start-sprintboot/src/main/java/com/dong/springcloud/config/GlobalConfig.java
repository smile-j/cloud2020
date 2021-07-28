package com.dong.springcloud.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/8
 */
@Configuration
@Slf4j
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class GlobalConfig {

   /* @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Kitty API Doc")
                .description("This is a restful api document of Kitty.")
                .version("1.0")
                .build();
    }*/

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dong.springcloud"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger-bootstrap-ui RESTful APIs")
                .description("swagger-bootstrap-ui")
                .termsOfServiceUrl("http://localhost:6001/")
                .contact("developer@mail.com")
                .version("1.0")
                .build();
    }

}
