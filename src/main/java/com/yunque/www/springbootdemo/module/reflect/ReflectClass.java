package com.yunque.www.springbootdemo.module.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 处理反射逻辑
 */
public class ReflectClass {
    private final static String TAG = "ReflectClass";

    /**
     * 通过反射创建对象
     */
    public static void reflectNewInstance() {
        try {
            //获取类的Class实例
            Class<?> aClass = Class.forName("com.yunque.www.springbootdemo.module.reflect.Book");
            Object object = aClass.newInstance();
            Book book = (Book) object;
            book.setAuthor("ccc");
            book.setName("无极");
            System.out.println(book.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //暴力破解私有构造函数
    public static void reflectPrivateConstructor() {
        try {
            Class<?> aClass = Class.forName("com.yunque.www.springbootdemo.module.reflect.Book");
            //获取指定类型的构造函数
            Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class, String.class);
            declaredConstructor.setAccessible(true);
            Object object = declaredConstructor.newInstance("name", "ccc");
            Book book = (Book) object;
            System.out.println(book.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射私有属性
     */
    public static void reflectPrivateField() {
        try {
            Class<?> aClass = Class.forName("com.yunque.www.springbootdemo.module.reflect.Book");
            Object object = aClass.newInstance();
            //传入属性的名称即可
            Field field = aClass.getDeclaredField("TAG");
            field.setAccessible(true);
            String tag = (String) field.get(object);
            //打印这个私有字段的值
            System.out.println(tag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //反射私有方法
    public static void reflectPrivateMethod() {
        try {
            Class<?> aClass = Class.forName("com.yunque.www.springbootdemo.module.reflect.Book");

            Object obj = aClass.newInstance();
            Method method = aClass.getDeclaredMethod("declaredMethod", int.class);
            method.setAccessible(true);
            //传递object对象 及参数调用该对象对应的方法
            String result = (String) method.invoke(obj, 0);
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
