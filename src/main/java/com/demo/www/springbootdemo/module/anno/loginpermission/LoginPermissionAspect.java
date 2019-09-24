package com.demo.www.springbootdemo.module.anno.loginpermission;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LoginPermissionAspect {

    private Logger logger = LoggerFactory.getLogger(LoginPermissionAspect.class);

    //定义切点
    @Pointcut("@annotation(com.demo.www.springbootdemo.module.anno.loginpermission.LoginPermission)")
    public void loginProcess() {

    }


    @Before("loginProcess()")
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        //获取注解以及对应的value值
        LoginPermission annotation = method.getAnnotation(LoginPermission.class);
        String value = annotation.value();
        logger.info("值是" + value);
        System.out.println("值是" + value);
    }

    @After("loginProcess()")
    public void afterPointcut(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        LoginPermission annotation = method.getAnnotation(LoginPermission.class);
        String value = annotation.value();
        logger.info("值是" + value);
    }

}
