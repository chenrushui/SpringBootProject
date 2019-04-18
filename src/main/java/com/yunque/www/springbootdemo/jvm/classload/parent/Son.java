package com.yunque.www.springbootdemo.jvm.classload.parent;

/**
 * Created on 2019/4/17.
 * author:crs
 * Description:XXX
 */
public class Son extends  Parent {
    static {
        System.out.println("son初始化...");
    }

    public static void main(String[] args) {

    }
}
