package com.dong.springcloud.comm.exception;

import com.dong.springcloud.comm.IResultCode;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/26
 */
public class BizException  extends BaseException{
    public BizException(IResultCode resultCode) {
        super(resultCode);
    }

    public BizException(IResultCode resultCode, String message, Throwable cause) {
        super(resultCode, message, cause);
    }
}
