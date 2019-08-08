package com.yunque.www.springbootdemo.config;

import com.yunque.www.springbootdemo.interceptor.RequestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自己写一个配置类
 * 实现WebMvcConfigurer接口
 */
@Configuration
public class CustomWebMvcConfig implements WebMvcConfigurer {
    //添加资源映射访问规则
    //添加视图映射规则(直接添加视图映射规则，不需要再Controller中写空方法)
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //如果用户访问的是/index路径，直接返回success资源。
        registry.addViewController("/index").setViewName("success");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有的网络请求
        registry.addInterceptor(new RequestInterceptor()).addPathPatterns("/**");

    }
}
