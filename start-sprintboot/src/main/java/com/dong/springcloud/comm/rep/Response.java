package com.dong.springcloud.comm.rep;

import com.dong.springcloud.comm.IResultCode;
import lombok.Data;

import java.io.Serializable;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/7
 */

@Data
public class Response<D> implements Serializable {

    private static final long serialVersionUID = 11L;
    protected D data;
    protected int code;
    protected String msg;
    protected String curTime;




    public Response() {
    }

    public Response(D data) {
        this.data = data;
    }

    public Response(IResultCode retCode) {
        setRetCode(retCode);
    }

    public Response(D data, IResultCode retCode) {
        setRetCode(retCode);
        this.data = data;
    }

    public void setRetCode(IResultCode retCode) {
        if (null == retCode) {
            return;
        }
        if (code == 0) {
            code = retCode.getCode();
        }
        if (null == msg) {
            msg = retCode.getMessage();
        }
    }



    /**
     * builder 方法
     */
    public Response<D> retCode(IResultCode retCode) {
        if (null == retCode) {
            return this;
        }
        if (code == 0) {
            code = retCode.getCode();
        }
        if (null == msg) {
            msg = retCode.getMessage();
        }
        return this;
    }
    public Response<D> code(int code) {
        this.code = code;
        return this;
    }
    public Response<D> msg(String msg) {
        this.msg = msg;
        return this;
    }
    public Response<D> curTime(String curTime) {
        this.curTime = curTime;
        return this;
    }
    public Response<D> data(D data) {
        this.data = data;
        return this;
    }


    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T> Response<T> ok(T data) {
        return new Response(data, IResultCode.ResultCodeEnum.SUCCESS);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T> Response<T> fail(IResultCode resultCode) {
        return new Response(resultCode);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T> Response<T> fail(String resultMessage) {
        return new Response(IResultCode.ResultCodeEnum.BIZERROR).msg(resultMessage);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T> Response<T> fail(IResultCode resultCode, String resultMessage) {
        return new Response(resultCode).msg(resultMessage);
    }

    public static <T> PageResponse<T> page(T data) {
        return page(data, null);
    }

    public static <T> PageResponse<T> page(T data, Long totalCount) {
        return new PageResponse<T>(data, totalCount, IResultCode.ResultCodeEnum.SUCCESS);
    }
}
