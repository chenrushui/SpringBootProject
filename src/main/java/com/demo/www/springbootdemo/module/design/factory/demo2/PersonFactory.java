package com.demo.www.springbootdemo.module.design.factory.demo2;

/**
 * Created on 2019/9/9 13:26
 * author:crs
 * Description:XXX
 */
public class PersonFactory {

    public static Person create(String name) {
        try {
            Class<?> aClass = Class.forName(name);
            return (Person) aClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }
}
