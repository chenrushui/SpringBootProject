//package com.yunque.www.springbootdemo.interceptor;
//
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * 添加一个拦截器，拦截所有的网络请求
// */
//public class RequestInterceptor extends HandlerInterceptorAdapter {
//    //日志类的使用
//    Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//       // logger.info("----->" + request.getRequestURI());
//        return super.preHandle(request, response, handler);
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        super.postHandle(request, response, handler, modelAndView);
//        //logger.info("----->请求结束");
//    }
//}
