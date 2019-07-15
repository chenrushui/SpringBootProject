package com.yunque.www.springbootdemo.anno.demo2;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MyBeanDefinitionRegistrar.class)
public @interface MyFirstAnnotation {
    String name() default "";

    int age() default 0;
}
