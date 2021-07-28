package com.dong.springcloud.comm.exception;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/26
 */
@Data
public class ExcepEntity {


    private String msg;

    private Integer code;

    private Throwable throwable;

}
