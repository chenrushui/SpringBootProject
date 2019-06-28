package com.yunque.www.springbootdemo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自己写一个配置类
 * WebMvcConfigurer接口可以扩展spring MVC的功能
 * 直接重写其中的方法即可
 */
@Configuration
public class MyMVCConfig implements WebMvcConfigurer {
    /**
     * 添加视图映射规则(直接添加视图映射规则，不需要再Controller中写空方法)
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }

}
