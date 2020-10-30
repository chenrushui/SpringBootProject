package com.demo.www.springbootdemo.crs.defaultt;

public class TestDefault {
    public static void main(String[] args) {
        //1，DefaultImpl子类可以不实现有default修饰的方法，但是在tomcat中会报错。
        //DefaultImpl aDefault = new DefaultImpl();
        //aDefault.method();

        //2，如果子类重写接口中default修饰的方法，则调用自己的方法
        DefaultImpl aDefault = new DefaultImpl();
        aDefault.method();
    }
}
