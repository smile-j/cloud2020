package com.dong.springcloud.comm.exception;

import com.dong.springcloud.comm.IResultCode;
import lombok.Data;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/22
 */
@Data
public class BaseException extends RuntimeException{

    private final IResultCode code;

    private final String message;

    public BaseException(IResultCode resultCode){
        this(resultCode,null,null);
    }

    public BaseException(IResultCode resultCode,String message,Throwable cause){
        super(cause);
        this.code = resultCode;
        if (null == message || message.length() == 0) {
            if (null != code) {
                message = code.getMessage();
            }else if (null != cause) {
                message = cause.getMessage();
            }
        }
        this.message = message;
    }
}
