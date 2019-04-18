package com.yunque.www.springbootdemo.jvm.classinit;

/**
 * Created on 2019/4/17.
 * author:crs
 * Description:类的初始化
 */
public class TestInitClass {

    static int i=1;

    static {
        i=0;
        System.out.println(i);
    }
    //static int i=1;

    //编译器收集的顺序是有语句在源文件中出现的顺序决定的。

}

