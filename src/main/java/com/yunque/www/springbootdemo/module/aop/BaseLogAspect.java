//package com.yunque.www.springbootdemo.aop;
//
//import com.alibaba.fastjson.JSONObject;
//import org.apache.commons.io.IOUtils;
//import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
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
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.Enumeration;
//
//@Component
//@Aspect
//public class BaseLogAspect {
//
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//    //get和set方法
//    ThreadLocal<Long> startTime = new ThreadLocal<>();
//    ThreadLocal<HttpServletRequest> request = new ThreadLocal();
//
//
//    public BaseLogAspect() {
//    }
//
//    //切点表达式
//    @Pointcut("execution(public * com.yunque.www..*Controller.*(..))")
//    public void baseLog() {
//
//    }
//
//    @Around(value = "baseLog()")
//    public Object doAround(ProceedingJoinPoint point) throws Throwable {
//        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest httpServletRequest = requestAttributes.getRequest();
//        this.request.set(httpServletRequest);
//        getHeaderInfo(httpServletRequest);
//        String url = httpServletRequest.getRequestURI();
//        String method = httpServletRequest.getMethod();
//        //通过判断请求方式获取请求参数
//        String queryString = null;
//        if ("GET".equalsIgnoreCase(method)) {
//            queryString = httpServletRequest.getQueryString();
//        } else if (!this.parseMultipart()) {
//            //如果不是文件上传，是post请求
//            queryString = this.getParamsFromJsonBody();
//        } else {
//            queryString = "";
//        }
//        this.startTime.set(System.currentTimeMillis());
//        logger.info("request params----->, url: {}, method: {}, uri: {}, params: {}", new Object[]{url, method, url, queryString});
//        //执行结果
//        Object object = point.proceed();
//        if (object != null) {
//            logger.info("request result----->" + object.toString());
//        }
//        //处理业务逻辑的时间消耗
//        logger.info("request spent time milliSeconds ==>" + (System.currentTimeMillis() - startTime.get()));
//        return object;
//    }
//
//    /**
//     * 获取请求头信息
//     *
//     * @param request
//     */
//    private void getHeaderInfo(HttpServletRequest request) {
//        //放到json里面
//        JSONObject jsonObject = new JSONObject();
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String key = headerNames.nextElement();
//            String value = request.getHeader(key);
//            jsonObject.put(key, value);
//        }
//        logger.info("request header----->" + jsonObject.toString());
//    }
//
//    /**
//     * 判断是否是文件上传？
//     *
//     * @return
//     */
//    private boolean parseMultipart() {
//        return ServletFileUpload.isMultipartContent(this.request.get());
//    }
//
//    /**
//     * 获取post请求参数,只需要打印所有的请求参数即可
//     */
//    private String getParamsFromJsonBody() throws IOException {
//        InputStream is = ((HttpServletRequest)this.request.get()).getInputStream();
//        InputStreamReader isr = new InputStreamReader(is, "utf-8");
//        String res = IOUtils.toString(isr);
//        isr.close();
//        is.close();
//        return res;
//    }
//
//
//}
