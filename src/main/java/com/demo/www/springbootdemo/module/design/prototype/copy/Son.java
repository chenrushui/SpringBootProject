package com.demo.www.springbootdemo.module.design.prototype.copy;

/**
 * Created on 2019/11/29 11:31
 * author:crs
 * Description:测试深拷贝
 */
public class Son implements Cloneable {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Son(int age) {
        super();
        this.age = age;
    }

    @Override
    public String toString() {
        return "Son [age=" + age + "]";
    }

}
