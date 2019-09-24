package com.demo.www.springbootdemo.module.demo;


class A implements B {
}


interface B{

}

public class ClassTest {

    public static void main(String[] args) {
        Class<A> aClass = A.class;
        //A.class封装了运行时的全部信息,全类型，类名，类加载器，获取当前类的父类，所实现的接口
        System.out.println(aClass.getName());
        System.out.println(aClass.getSimpleName());
        System.out.println(aClass.getClassLoader());
        System.out.println(aClass.getSuperclass());
        System.out.println(aClass.getInterfaces()[0]);
    }

}
