package com.dong.springcloud.comm;

/**
 * @author dongjunpeng
 * @Description 订单模块的返回码
 * @date 2021/12/3
 */
public interface OrderResultCode extends IResultCode{
    int getCode();
    String getMessage();

    enum IOrderResultCodeEnum implements OrderResultCode{
        SUCCESS(200,"成功"),
        BIZERROR(400,"业务异常"),
        PARAMS_ERROR(4001, "参数错误"),
        EXCEPTION_ERROR(4002, "接口异常，请联系管理员"),
        REPEAT_SUBMIT(4003, "请勿重复提交!"),

        ORDER_CONFIG_(50100,"订单配置相关的错误"),
        ORDER_PAY_(600100,"订单支付的相关错误码")
        ;

        private IOrderResultCodeEnum(int code,String message){
            this.code = code;
            this.message = message;
        }
        final int code;
        final String message;
        @Override
        public int getCode() {
            return this.code;
        }

        @Override
        public String getMessage() {
            return null;
        }
    }

}
