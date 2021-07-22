package com.dong.springcloud.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/8
 */
@Data
public class UserEntity {

    static {
        System.out.println("--------static------UserEntity--------");
    }

    private Integer id;
    private String userName;
    private String pwd;
    private String address;
    private Integer age;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date born;
    private Boolean flag;

}
