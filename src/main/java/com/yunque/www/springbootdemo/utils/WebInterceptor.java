package com.yunque.www.springbootdemo.utils;

import com.yunque.www.springbootdemo.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 拦截器
 */
@Component
public class WebInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(WebInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler != null && handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            if (handlerMethod.getBean() != null && handlerMethod.getBean() instanceof BaseController) {
                BaseController baseController = (BaseController) handlerMethod.getBean();
            }
        }
        //获取请求头信息
        logger.info("request header params--->" + this.getHeaderInfo(request));


        return super.preHandle(request, response, handler);
    }

    /**
     * 获取请求信息
     *
     * @param request
     * @return
     */
    private Map<String, Object> getHeaderInfo(HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key =headerNames.nextElement();
            Object value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
}
