package com.dong.springcloud.comm.enums;

/**
 * @author dongjunpeng
 * @Description 服务编码
 * @date 2021/7/21
 */
public enum ServiceStatus {
    AVAILABLE("00","可用"),
    UNAVAILABLE("01","不可用");

    private ServiceStatus(String code,String name){
        this.code = code;
        this.name = name;
    }
    private String code;
    private String name;

}
