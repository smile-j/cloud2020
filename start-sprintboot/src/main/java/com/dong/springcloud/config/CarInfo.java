package com.dong.springcloud.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/9/3
 */
@ConfigurationProperties(prefix = "mycar")
@Data
//@Component
public class CarInfo {

    private String brand;
    private Integer price;

}
