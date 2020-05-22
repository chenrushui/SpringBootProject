package com.demo.www.springbootdemo.module.classloader;

/**
 * Created on 2020/4/26 15:03
 * author:crs
 * Description:XXX
 */
public class TestClassLoader {
    //测试类加载器

    public static void main(String[] args) {
        //打印出当前类的加载器
        System.out.println(TestClassLoader.class.getClassLoader());
    }


}
