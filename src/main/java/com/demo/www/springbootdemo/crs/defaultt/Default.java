package com.demo.www.springbootdemo.crs.defaultt;


/**
 * 接口定义
 */
public interface Default {

    //接口中的方法可以有方法体
    default void method(){
        System.out.println("method in interface");
    }
}
