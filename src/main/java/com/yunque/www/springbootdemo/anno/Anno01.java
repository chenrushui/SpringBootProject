package com.yunque.www.springbootdemo.anno;

import net.bytebuddy.implementation.bind.annotation.RuntimeType;

import java.lang.annotation.*;

/**
 * Created on 2019/4/10.
 * author:crs
 * Description:自定义注解
 */
@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Anno01 {

    /**
     * 1)定义了一个名称为Anno01的注解
     * 2)能够使用在method上
     * 3)参数类型为String,参数名为Value
     * 4)给参数设置默认值（用户使用可以不给定参数值；如果没有默认值，用户使用注解的时候必须要给定参数值）
     * 5)如果没有给定默认值，使用注解时，必须给值。
     * 5)@Anno01(value = "测试数据") 注解的使用
     */

    String value() default "";
    int age() default 0;
    String[] schools() default {""};


}
