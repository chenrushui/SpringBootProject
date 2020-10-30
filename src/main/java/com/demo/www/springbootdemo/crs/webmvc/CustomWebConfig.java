package com.demo.www.springbootdemo.crs.webmvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class CustomWebConfig implements WebMvcConfigurer {

    /**
     * 为所有请求添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        RequestInterceptor requestInterceptor = new RequestInterceptor();
        registry.addInterceptor(requestInterceptor).addPathPatterns("/mvc");
        registry.addInterceptor(requestInterceptor)
                .addPathPatterns("/admin")
                .excludePathPatterns("/emp/toLogin", "/emp/login", "/js/**", "/css/**", "/images/**");
    }

    //静态资源访问：http://localhost:8000/my/sql.sql 比如css，js等资源。
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/my/**").addResourceLocations("classpath:/res/");
    }

    //页面跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    //视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

    }

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}
