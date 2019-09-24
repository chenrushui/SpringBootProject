package com.demo.www.springbootdemo.module.jvm.classload.statics;

/**
 * Created on 2019/4/17.
 * author:crs
 * Description:TestFinal
 */
public class TestFinal {
    static {
        System.out.println("TestFinal");
    }

    public static void main(String[] args) {
        System.out.println(Aaa.var);


    }
}

class Aaa {

    //public final static String var = "1111";
    public static String var = "1111";

    static {
        System.out.println("Aaa");
    }

}

