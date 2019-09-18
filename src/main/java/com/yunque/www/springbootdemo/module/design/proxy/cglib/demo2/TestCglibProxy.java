package com.yunque.www.springbootdemo.module.design.proxy.cglib.demo2;

/**
 * Created on 2019/4/11.
 * author:crs
 * Description:TestCglibProxy
 */
public class TestCglibProxy {
//    public static void main(String[] args) {
////        Car car = new Car();
//        CglibProxy cglibProxy = new CglibProxy();
//        //作用是创建一段动态地类字节码
//        Enhancer enhancer = new Enhancer();
//        //设置父类，也就是使用传递过来的类来创建代理类
//        enhancer.setSuperclass(Car.class);
//        ////这个回调函数就是把调用的方法改为CglibProxy中的inteceptor方法，并称此行为为增强目标类
//        enhancer.setCallback(cglibProxy);
//        Car carProxy= (Car) enhancer.create();
//        carProxy.move();
//
//    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s3.intern());//true
    }

    //变量s1：java虚拟机栈中的局部变量表中，对象在堆内存中的地址；"abc"存在常量池中，HashSet集合字符串常量表（内存地址）
}
