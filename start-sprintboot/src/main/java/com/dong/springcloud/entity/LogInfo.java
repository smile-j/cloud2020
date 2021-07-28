package com.dong.springcloud.entity;

import com.sun.org.apache.xpath.internal.operations.String;
import lombok.Data;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/26
 */
@Data
public class LogInfo {

    private String type;
    private String info;
    private Data curTime;

}
