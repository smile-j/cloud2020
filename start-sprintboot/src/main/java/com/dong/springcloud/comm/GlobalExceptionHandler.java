package com.dong.springcloud.comm;

import com.dong.springcloud.comm.exception.BaseException;
import com.dong.springcloud.comm.exception.BizException;
import com.dong.springcloud.comm.rep.Response;
import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dongjunpeng
 * @Description 全局异常处理
 * @date 2021/7/22
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    private static final String CHAR_SET = "UTF-8";

    private static final String STR_PARAMETER_IS_ERROR = "参数有误";

    private static final String CONTENT_TYPE_TEXT = MediaType.TEXT_HTML_VALUE + ";charset=UTF-8";

    /**
     * 处理自定义的业务异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public Response bizExceptionHandler(HttpServletRequest req, BaseException e){
        log.error("发生业务异常！原因是：{}",e.getMessage());
        return Response.fail(e.getCode(),e.getMessage());
    }

    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =NullPointerException.class)
    @ResponseBody
    public Response exceptionHandler(HttpServletRequest req, NullPointerException e){
        log.error("发生空指针异常！原因是:",e);
        return Response.fail(IResultCode.ResultCodeEnum.SYSERROR,"NullPointerException");
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    public Response<Object> handleNotFound() {
        log.warn("not_found");
        return Response.fail(IResultCode.ResultCodeEnum.NOTFOUND, "Resource Not Found");
    }

    @ExceptionHandler(ServletException.class)
    public Response<Object> handleSerlvetException(ServletException e){
        return Response.fail(IResultCode.ResultCodeEnum.METHODNOTALLOW, e.getMessage());
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Response<Object> handleHttpMessageException(HttpMessageNotReadableException e){
        return Response.fail(IResultCode.ResultCodeEnum.FAILCODE, e.getMessage());
    }

    @ExceptionHandler(BindException.class)
    public Response<Object> handleBadRequest(BindException e) {
        return Response.fail(IResultCode.ResultCodeEnum.FAILCODE, handleResult(e));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<Object> handleBadRequest(MethodArgumentNotValidException e) {
        return Response.fail(IResultCode.ResultCodeEnum.FAILCODE, handleResult(e.getBindingResult()));
    }




    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public Response exceptionHandler(HttpServletRequest req, HttpServletResponse response, Exception e){
        log.error("未知异常！原因是:",e);
        return Response.fail(IResultCode.ResultCodeEnum.SYSERROR,e.getMessage());
    }

    private String handleResult(BindingResult bindingResult) {
        try {
            List<ObjectError> errorList = bindingResult.getAllErrors();
            if (CollectionUtils.isEmpty(errorList)) {
                return STR_PARAMETER_IS_ERROR;
            }
            List<String> toastList = errorList.stream().map(e -> ((FieldError) e).getField() + " " + e.getDefaultMessage()).collect(Collectors.toList());
            String toast = Joiner.on(", ").skipNulls().join(toastList);
            log.info("请求参数:{}", bindingResult.getTarget() == null ? "数据缺失" : bindingResult.getTarget().toString());
            log.info("请求失败原因:{}", toast);
            return toast;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return STR_PARAMETER_IS_ERROR;
        }
    }

}
