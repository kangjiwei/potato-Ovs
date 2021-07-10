package com.potato.core.exption;

import com.potato.core.context.DCFRespBody;
import com.potato.core.context.DCFRespMsg;
import com.potato.core.enums.RetCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jiwei.kang
 * @Date 2021.1.8
 * @describe 全局捕捉异常
 */
@ControllerAdvice
@ResponseBody
public class BusinessExceptionHandler {

    @Autowired
    DCFRespMsg dcfRespMsg;

    private static final Logger logger = LoggerFactory.getLogger(BusinessExceptionHandler.class);

    /**
     * 异常捕捉
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public DCFRespBody exceptionHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        DCFRespBody responseBody = dcfRespMsg.getResponseBody(RetCode.OP_FAIL);
        responseBody.setMessage(e.getMessage());
        return responseBody;
    }

    // <1> 处理 form data方式调用接口校验失败抛出的异常
    @ExceptionHandler(BindException.class)
    public DCFRespBody bindExceptionHandler(BindException e) {
        logger.error("error info:[{}]", e.getMessage());
        e.printStackTrace();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<String> collect = fieldErrors.stream()
                .map(o -> o.getDefaultMessage())
                .collect(Collectors.toList());
        logger.info("BindException error info :{}", collect);
        DCFRespBody responseBody = dcfRespMsg.getResponseBody(RetCode.OP_FAIL);
        responseBody.setMessage(String.join(",", collect));
        return responseBody;
    }

    // <2> 处理 json 请求体调用接口校验失败抛出的异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public DCFRespBody methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        logger.error("error info:[{}]", e.getMessage());
        e.printStackTrace();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<String> collect = fieldErrors.stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        logger.info("error info :{}", collect);
        DCFRespBody responseBody = dcfRespMsg.getResponseBody(RetCode.OP_FAIL);
        responseBody.setMessage(String.join(",", collect));
        return responseBody;
    }

}