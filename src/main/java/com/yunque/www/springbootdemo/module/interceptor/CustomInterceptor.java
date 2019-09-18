package com.yunque.www.springbootdemo.module.interceptor;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

/**
 * 日志拦截器
 */
@Component
@Aspect
public class CustomInterceptor {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    ThreadLocal<HttpServletRequest> requestThreadLocal = new ThreadLocal();
    ThreadLocal<Long> startTime = new ThreadLocal();

    @Pointcut("execution(public * com.yunque.www..*Controller.*(..))")
    public void picaLog() {

    }

    /**
     * 环绕通知
     *
     * @param point
     * @return
     */
    @Around("picaLog()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        requestThreadLocal.set(request);
        startTime.set(System.currentTimeMillis());
        logger.info("---------------------------->");
        logger.info("request start: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        processRequestHeader();
        processRequestParams(point);
        Object result = point.proceed();
        if (result != null) {
            //响应结果
            logger.info("request result: " + JSONObject.toJSONString(result));
        }
        logger.info("request spent time: " + (System.currentTimeMillis() - startTime.get()));
        return result;
    }

    /**
     * 处理请求参数
     *
     * @param point
     */
    private void processRequestParams(ProceedingJoinPoint point) {
        String params = null;
        HttpServletRequest request = requestThreadLocal.get();
        String url = request.getRequestURI();
        String method = request.getMethod();
        //如果是get请求
        if ("GET".equalsIgnoreCase(method)) {
            params = request.getQueryString();
        } else if (!checkFileUpload()) {
            Object[] args = point.getArgs();
            params = JSONArray.toJSONString(args);
        } else {
            params = "";
        }
        logger.info("request params: url:{},method:{},params:{}", new Object[]{url, method, params});
    }

    /**
     * 判断是否是文件上传
     *
     * @return
     */
    private boolean checkFileUpload() {
        return ServletFileUpload.isMultipartContent(requestThreadLocal.get());
    }

    /**
     * 处理请求头信息
     */
    private void processRequestHeader() {
        JSONObject jsonObject = new JSONObject();
        HttpServletRequest request = requestThreadLocal.get();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            jsonObject.put(key, value);
        }
        logger.info("request header: " + jsonObject.toString());
    }
}
