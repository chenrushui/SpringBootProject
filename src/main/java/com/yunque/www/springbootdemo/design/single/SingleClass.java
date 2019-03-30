package com.yunque.www.springbootdemo.design.single;

/**
 * Created on 2019/2/2.
 * author:crs
 * Description:如何实现最为高效的单例模式？
 */

public class SingleClass {

    //静态变量的初始化
    private static SingleClass instance = new SingleClass();

    private SingleClass() {
    }

    public static SingleClass getInstance() {
        return instance;
    }

}

