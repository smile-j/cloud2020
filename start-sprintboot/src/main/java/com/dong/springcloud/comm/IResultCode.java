package com.dong.springcloud.comm;

import org.springframework.boot.logging.LogLevel;

/**
 * @author dongjunpeng
 * @Description  系统的返回码
 * @date 2021/7/7
 */
public interface IResultCode {

    int getCode();
    String getMessage();

    public static final int SUCCESS = 10000;
    public static final int BIZERROR = 10001;
    public static final int UNAUTHORIZED = 10002;
    public static final int FORBIDDEN = 10003;
    public static final int SYSERROR = 10004;

    public static final int FAIL_CODE = 400;
    public static final int NOT_FOUND = 404;
    public static final int METHOD_NOT_ALLOW = 405;

    public enum ResultCodeEnum implements IResultCode{
        SUCCESS(IResultCode.SUCCESS, "成功",LogLevel.INFO),
        BIZERROR(IResultCode.BIZERROR, "业务异常",LogLevel.INFO),
        UNAUTHORIZED(IResultCode.UNAUTHORIZED, "未登录或登录已过期",LogLevel.INFO),
        FORBIDDEN(IResultCode.FORBIDDEN, "没有权限",LogLevel.WARN),
        SYSERROR(IResultCode.SYSERROR, "系统异常",LogLevel.ERROR),
        FAILCODE(IResultCode.FAIL_CODE, "参数错误",LogLevel.ERROR),
        NOTFOUND(IResultCode.NOT_FOUND, "404",LogLevel.ERROR),
        METHODNOTALLOW(IResultCode.METHOD_NOT_ALLOW, "not allowed",LogLevel.ERROR),
        ;

        ResultCodeEnum(int code, String message) {
            this(code,message,LogLevel.ERROR);
        }

        ResultCodeEnum(int code, String message, LogLevel logLevel) {
            this.code = code;
            this.message = message;
            this.logLevel = logLevel;
        }
        final int code;

        final String message;

        final LogLevel logLevel;

        @Override
        public int getCode() {
            return 0;
        }

        @Override
        public String getMessage() {
            return null;
        }

        public LogLevel getLogLevel(){
            return logLevel;
        }
    }


}
