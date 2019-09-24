package com.demo.www.springbootdemo.module.request;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取请求头中的信息
 */
@Component
public class RequestUtils {

    /**
     * 获取HttpServletRequest对象
     *
     * @return
     */
    public  HttpServletRequest httpServletRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        return request;

    }

    /**
     * 获取HttpServletResponse对象
     *
     * @return
     */
    public  HttpServletResponse getHttpServletResponse() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = ((ServletRequestAttributes) requestAttributes).getResponse();
        return response;
    }

    /**
     * 获取token
     *
     * @return
     */
    public  String getTokenFromHead() {
        String token = httpServletRequest().getHeader("token");
        return token;
    }

    /**
     * 获取sysCode
     *
     * @return
     */
    public  String getSyscodeFromHead() {
        String sysCode = httpServletRequest().getHeader("sysCode");
        return sysCode;
    }

    /**
     * 获取设备信息
     *
     * @return
     */
    public  String getDeviceInfoFromHead() {
        return httpServletRequest().getHeader("deviceInfo");
    }


}
