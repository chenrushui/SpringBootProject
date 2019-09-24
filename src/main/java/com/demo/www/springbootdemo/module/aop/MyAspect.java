package com.demo.www.springbootdemo.module.aop;

import com.demo.www.springbootdemo.pojo.User;
import com.demo.www.springbootdemo.validate.UserValidator;
import com.demo.www.springbootdemo.validate.UserValidatorImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspect {

    /**
     * 采用@Aspect的注解方式实现AOP功能
     * JoinPoint类的使用
     * 如何向通知中传递参数？
     */

    @DeclareParents(value = "com.demo.www.springbootdemo.service.serviceimpl.UserServiceImpl", defaultImpl = UserValidatorImpl.class)
    public UserValidator userValidator;

    @Pointcut("execution(* com.demo.www.springbootdemo.service.serviceimpl.UserServiceImpl.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()&&args(user)")
    public void before(JoinPoint point, User user) {
        System.out.println("before");
        Object[] args = point.getArgs();
        User u = (User) args[0];
        System.out.println(u.toString()
        );
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        jp.proceed();
    }

    @After("pointCut()")
    public void after() {
        System.out.println("after");

    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("afterReturning");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }
}
