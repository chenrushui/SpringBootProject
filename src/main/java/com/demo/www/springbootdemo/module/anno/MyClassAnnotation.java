package com.demo.www.springbootdemo.module.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created on 2019/3/18.
 * author:crs
 * Description:XXX
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyClassAnnotation {
    // 系统名称
    String sysName() default "";

    // 唯一标识id
    int id();

    // 操作描述
    String desc() default "";
}
