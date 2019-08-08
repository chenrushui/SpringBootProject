package com.yunque.www.springbootdemo.exceptions;

import com.yunque.www.springbootdemo.pojo.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;


//@ControllerAdvice(annotations = RestController.class)
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private String JSON_FORMAT_TEMP = "{\"code\": \"%s\",\"message\": \"%s\",\"from\": \"%s\",\"path\": \"%s\"}";
    private HttpHeaders headers = null;

    public GlobalExceptionHandler() {
        this.headers = new HttpHeaders();
        this.headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
    }

    /**
     * 是否要区分异常级别,是error级别还是warn级别?
     *
     * @param serviceException
     * @param request
     * @return
     */
    @ExceptionHandler(value = ServiceException.class)
    public ResponseEntity<BaseResult> handlerServiceException(ServiceException serviceException, HttpServletRequest request) {
        return processException(serviceException.getCode(), serviceException.getMessage(), serviceException, request, Level.ERROR);
    }

    @ExceptionHandler(value = SystemException.class)
    public ResponseEntity<BaseResult> handlerSystemException(SystemException systemException, HttpServletRequest request) {
        //如果日志文件中错误码为500000，系统级异常
        return processException(PicaResultCode.SYSTEM_EXCEPTION.getCode(), PicaResultCode.SYSTEM_EXCEPTION.getMessage(), systemException, request, Level.ERROR);
    }

    /**
     * 处理异常信息
     *
     * @param code
     * @param message
     * @param exception
     * @param request
     * @param level
     * @return
     */
    private ResponseEntity<BaseResult> processException(String code, String message, Exception exception, HttpServletRequest request, Level level) {
        String json = String.format(JSON_FORMAT_TEMP, code, message, request.getRemoteAddr(), request.getRequestURI() + "?" + request.getQueryString());
        if (level == Level.ERROR) {
            logger.error(json, exception);
        }
        //todo：返回给前端一个ResponseEntity对象，里面包含错误的信息
        //return new ResponseEntity<BaseResult>(new BaseResult().Builder().setCode(code).setMessage(message).build(), headers, HttpStatus.OK);
        return null;
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.error(ex.getMessage(), ex);
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute("javax.servlet.error.exception", ex, WebRequest.SCOPE_REQUEST);
        }
        return new ResponseEntity<Object>(body, headers, status);
    }
}
