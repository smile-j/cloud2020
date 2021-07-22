package com.dong.springcloud.vo.req;

import lombok.Data;

import java.util.Date;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/8
 */
@Data
public class UserVo {

    private Integer id;
    private String userName;
    private String pwd;
    private String add;
    private Integer age;
    private Date startTime;
    private Date endTime;
    private Boolean flag;
    private String address;

}
