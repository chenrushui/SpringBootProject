package com.yunque.www.springbootdemo.exceptions;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.yunque.www.springbootdemo.pojo.BaseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2019/3/17.
 * author:crs
 * Description:自定义异常处理器
 */
//@ControllerAdvice(annotations = RestController.class)
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    public CustomExceptionHandler() {
    }

    @ExceptionHandler(PicaException.class)
    public final ResponseEntity<BaseBean> handlerGeneralException(PicaException ex, HttpServletRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
        BaseBean baseBean = new BaseBean();
        baseBean.setCode(ex.getCode());
        baseBean.setMessage(ex.getMsg());
        this.logError(ex, request, baseBean);
        return new ResponseEntity(baseBean, headers, HttpStatus.OK);
    }

    @ExceptionHandler({Exception.class})
    public final ResponseEntity<BaseBean> handleGeneralException(Exception ex, HttpServletRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
        BaseBean baseBean = new BaseBean();
        baseBean.setCode(PicaResultCode.INTERFACE_INVOKE_EXCEPTION.getCode());
        baseBean.setMessage(PicaResultCode.INTERFACE_INVOKE_EXCEPTION.getMessage());
        this.logError(ex, request, baseBean);
        return new ResponseEntity(baseBean, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public void logError(Exception ex) {
        Map<String, String> map = new HashMap();
        map.put("message", ex.getMessage());
        this.logger.error(JSONObject.toJSONString(map), ex);
    }

    /**
     * 打印错误信息
     *
     * @param ex
     * @param request
     * @param baseBean
     */
    private void logError(Exception ex, HttpServletRequest request, BaseBean baseBean) {
        HashMap<String, String> map = new HashMap();
        map.put("code", baseBean.getCode());
        map.put("message", baseBean.getMessage());
        map.put("from", request.getRemoteAddr());
        //a=b&c=d&e=f
        String queryString = request.getQueryString();
        map.put("path", queryString != null ? request.getRequestURI() + "?" + queryString : request.getRequestURI());
        //调用Logger系统的error()方法
        this.logger.error(JSONObject.toJSONString(map), ex);
    }
}
