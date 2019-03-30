package com.yunque.www.springbootdemo.anno;

import java.lang.annotation.*;

/**
 * Created on 2019/3/18.
 * author:crs
 * Description:XXX
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyMethodAnnotation {
    String methodDesc() default "该方法没有描述";
}
