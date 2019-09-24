//package com.yunque.www.springbootdemo.exceptions;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.slf4j.event.Level;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import javax.servlet.http.HttpServletRequest;
//
//@ControllerAdvice(annotations = {RestController.class})
//public class CustomExceptionHandler2 extends ResponseEntityExceptionHandler {
//
//    private Logger logger = LoggerFactory.getLogger(CustomExceptionHandler2.class);
//    String JSON_FORMAT_TEMP = "{\"code\": \"%s\",\"message\": \"%s\",\"from\": \"%s\",\"path\": \"%s\"}";
//
//    private HttpHeaders headers = null;
//
//    public CustomExceptionHandler2() {
//        this.headers = new HttpHeaders();
//        this.headers.setContentType(MediaType.parseMediaType(MediaTypes.JSON_UTF_8));
//    }
//
//    @ExceptionHandler(value = {PicaException.class})
//    public final ResponseEntity<PicaResponse> handleServiceException(PicaException ex, HttpServletRequest request) {
//        return commonProcess(ex.getCode(), ex.getMsg(), ex, request, Level.ERROR);
//    }
//
//    @ExceptionHandler(value = {PicaWarnException.class})
//    public final ResponseEntity<PicaResponse> handleServiceException(PicaWarnException ex, HttpServletRequest request) {
//        return commonProcess(ex.getCode(), ex.getMsg(), ex, request, Level.WARN);
//    }
//
//    @ExceptionHandler(value = {Exception.class})
//    public final ResponseEntity<PicaResponse> handleGeneralException(Exception ex, HttpServletRequest request) {
//        return commonProcess(PicaResultCode.INTERFACE_INVOKE_EXCEPTION.code(), PicaResultCode.INTERFACE_INVOKE_EXCEPTION.message(), ex, request, Level.ERROR);
//    }
//
//    public ResponseEntity<PicaResponse> responseEntity(String code, String message, Exception ex, HttpServletRequest request, Level level) {
//        String json = String.format(JSON_FORMAT_TEMP, res.getCode(), res.getMessage(), request.getRemoteAddr(), request.getRequestURI() + "?" + request.getQueryString());
//
//        if (level == Level.ERROR) {
//            logger.error(json, ex);
//        } else {
//            logger.warn(json, ex);
//        }
//
//        return new ResponseEntity<PicaResponse>(new PicaResponse.Builder().setCode(code).setMessage(message).build(), headers, HttpStatus.OK);
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        logger.error(ex.getMessage(), ex);
//        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
//            request.setAttribute("javax.servlet.error.exception", ex, WebRequest.SCOPE_REQUEST);
//        }
//        return new ResponseEntity<Object>(body, headers, status);
//    }
//}
