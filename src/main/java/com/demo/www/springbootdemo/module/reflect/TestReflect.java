package com.demo.www.springbootdemo.module.reflect;

public class TestReflect {

    public static void main(String[] args) {

        //创建对象
        ReflectClass.reflectNewInstance();

        //反射私有的构造方法
        ReflectClass.reflectPrivateConstructor();

        //反射私有属性，打印私有属性的值
        ReflectClass.reflectPrivateField();

        //反射私有方法
        ReflectClass.reflectPrivateMethod();

        //通过反射打印类的信息

        try {
            Class<?> aClass = Class.forName("com.demo.www.springbootdemo.module.reflect.Book");
            System.out.println("类所在的包名：----->" + aClass.getPackage());
            System.out.println("类加载器：----->" + aClass.getClassLoader());
            System.out.println("类的父类：----->" + aClass.getSuperclass());
            System.out.println("类的父类：----->" + aClass.getInterfaces());
            System.out.println("类的简单名称：----->" + aClass.getSimpleName());
            System.out.println("类的完整路径名称：----->" + aClass.getName());
            System.out.println("类的所有公共属性：----->" + aClass.getFields());

            //根据类的名称，返回类的实例
            Book mBook = (Book) aClass.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
