package com.yunque.www.springbootdemo.anno;

/**
 * Created on 2019/3/18.
 * author:crs
 * Description:XXX
 */
public @interface MyClassAnnotation {
    // 系统名称
    String sysName() default "";

    // 唯一标识id
    int id();

    // 操作描述
    String desc() default "";
}
