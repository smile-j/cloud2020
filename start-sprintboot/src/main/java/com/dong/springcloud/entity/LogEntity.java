package com.dong.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/10/29
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LogEntity {

    private Integer id;
    private String content;
    private Date createTime;
    private Integer type;

}
