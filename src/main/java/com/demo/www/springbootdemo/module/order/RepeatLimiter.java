package com.demo.www.springbootdemo.module.order;

import java.lang.annotation.*;

/**
 * Created on 2020/4/23 15:46
 * author:crs
 * Description:幂等操作的注解
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RepeatLimiter {

}
