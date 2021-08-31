package com.dong.springcloud.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;


/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/26
 */
@Data
//@Accessors(chain = true)
@Builder
public class LogInfo {

    private String type;
    private String info;
    private Date curTime;

}
