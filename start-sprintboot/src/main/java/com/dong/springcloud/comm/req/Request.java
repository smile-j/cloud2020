package com.dong.springcloud.comm.req;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/8
 */
public class Request<T> implements Serializable {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
