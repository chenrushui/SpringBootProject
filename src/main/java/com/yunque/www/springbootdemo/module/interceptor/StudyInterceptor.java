//package com.yunque.www.springbootdemo.interceptor;
//
//import com.alibaba.fastjson.JSONObject;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Enumeration;
//
////@Aspect
////@Component
//public class StudyInterceptor {
//    private ThreadLocal<HttpServletRequest> local = new ThreadLocal();
//    private ThreadLocal<Long> startTime = new ThreadLocal<>();
//
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//
//    public StudyInterceptor() {
//
//    }
//
//    @Pointcut("execution(public * com.yunque.www..*Controller.*(..))")
//    public void baseLogPrint() {
//
//    }
//
//    @Around("baseLogPrint()")
//    public Object doAround(ProceedingJoinPoint point) throws Throwable {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        local.set(request);
//        startTime.set(System.currentTimeMillis());
//        String headers = processRequestHeader();
//        logger.info("----------------------------------------------->");
//        logger.info("request header:" + headers);
//        processRequestParams();
//        Object result = point.proceed();
//        if (result != null) {
//            logger.info("response:" + JSONObject.toJSONString(result));
//        }
//        logger.info("request spent:" + (System.currentTimeMillis() - startTime.get()));
//        return result;
//    }
//
//    /**
//     * 获取请求参数信息
//     */
//    private void processRequestParams() {
//        HttpServletRequest request = local.get();
//        String method = request.getMethod();
//        if ("GET".equalsIgnoreCase(method)) {
//            //如果是get请求
//            String queryString = request.getQueryString();
//            String url = request.getRequestURL().toString();
//            logger.info("request params: method:{}，url:{}，params:{}", new Object[]{method, url, queryString});
//        }
//    }
//
//    /**
//     * 获取请求头信息
//     *
//     * @return
//     */
//    private String processRequestHeader() {
//        HttpServletRequest request = local.get();
//        JSONObject jsonObject = new JSONObject();
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String key = headerNames.nextElement();
//            String value = request.getHeader(key);
//            jsonObject.put(key, value);
//
//        }
//        return jsonObject.toString();
//    }
//
//}
