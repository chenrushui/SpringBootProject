package com.yunque.www.springbootdemo.module.anno.visitpermission;

import java.lang.annotation.*;

/**
 * 访问权限注解
 */
@Target(ElementType.METHOD)     //方法上
@Retention(RetentionPolicy.RUNTIME) //作用域
@Documented
public @interface VisitPermission {
    //传递hospitalId的值进来
    //long hospitalId();  //通过反射可以获取方法上的参数
}
