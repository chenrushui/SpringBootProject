package com.yunque.www.springbootdemo.exceptions.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 全局异常设计
 */
@ControllerAdvice
public class BaseGlobalException extends ResponseEntityExceptionHandler {

    /**
     * 处理业务异常，并且把异常信息传递进来
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity processServiceException(BaseException exception) {
        String code = exception.getCode();
        String msg = exception.getMsg();
        return new ResponseEntity(new BaseResponse.Builder().setCode(code).setMsg(msg), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
