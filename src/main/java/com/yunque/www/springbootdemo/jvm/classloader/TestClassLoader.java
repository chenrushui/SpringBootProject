package com.yunque.www.springbootdemo.jvm.classloader;

/**
 * Created on 2019/4/17.
 * author:crs
 * Description:TestClassLoader
 */
public class TestClassLoader {
    public static void main(String[] args) {
        try {
            ClassLoader loader = new CustomClassLoader();
            Class<?> aClass = loader.loadClass("com.yunque.www.springbootdemo.jvm.classinit.TestInitClass");
            Object obj = aClass.newInstance();
            System.out.println(obj.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.gc();
    }
}
