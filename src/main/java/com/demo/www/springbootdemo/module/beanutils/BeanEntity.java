package com.demo.www.springbootdemo.module.beanutils;

/**
 * Created on 2020/1/14 10:33
 * author:crs
 * Description:XXX
 */
public class BeanEntity {

    private String  name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "BeanEntity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
