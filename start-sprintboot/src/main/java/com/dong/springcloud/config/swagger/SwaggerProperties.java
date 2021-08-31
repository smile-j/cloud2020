package com.dong.springcloud.config.swagger;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/30
 */
@ConfigurationProperties("comm.swagger")
@Configuration
@Slf4j
@Data
public class SwaggerProperties {

    private String title = "";
    private String description = "";
    private String version = "1.0.0";
    private List<String> basePath = new ArrayList();
    private List<String> excludePath = new ArrayList();
    private String host="";
    private List<SwaggerProperties.DocketInfo> docket = new ArrayList();

    @Data
    public static class DocketInfo {
        private String docketName;
        private String title = "";
        private String description = "";
        private String version = "";
        private String license = "";
        private String licenseUrl = "";
        private String termsOfServiceUrl = "";
        private String[] basePackage;
        private String name = "";
        private String url = "";
        private String email = "";

        private List<String> basePath = new ArrayList();
        private List<String> excludePath = new ArrayList();
    }
}
