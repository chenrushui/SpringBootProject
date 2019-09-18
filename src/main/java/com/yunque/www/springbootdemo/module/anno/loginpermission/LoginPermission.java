package com.yunque.www.springbootdemo.module.anno.loginpermission;

import java.lang.annotation.*;

/**
 * 判断用户登陆权限
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginPermission {
    String value() default "";
}
