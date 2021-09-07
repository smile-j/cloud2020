package com.dong.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;

import java.util.Date;


/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/26
 */
@Data
//@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogInfo {

    private String type;
    private String info;
    private Date curTime;

}
