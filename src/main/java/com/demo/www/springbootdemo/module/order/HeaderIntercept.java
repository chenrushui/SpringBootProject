package com.demo.www.springbootdemo.module.order;

import org.springframework.stereotype.Component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 2020/4/23 15:47
 * author:crs
 * Description:请求拦截器
 */
@Component
public class HeaderIntercept implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取token
        String token = request.getHeader("token");
        //校验逻辑
        if (!validToken(token)){
            //throw new TokenInvalidException("TOKEN失效");
        }

//        //获取其他的参数.....
//        RequestHeader header = RequestHeader.builder()
//                .token(token)
//                .build();
//        //放入request中
//        request.setAttribute("headerInfo",header);
        return true;
    }

    /**
     * 校验token，逻辑自己实现
     * @param token
     * @return
     */
    private boolean validToken(String token){
        return Boolean.TRUE;
    }

}
