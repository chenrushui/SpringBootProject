package com.demo.www.springbootdemo.module.design.prototype.demo1;

/**
 * Created on 2019/12/2 11:36
 * author:crs
 * Description:XXX
 */
public class Student implements  Cloneable {
    //引用类型
    private Subject subject;
    //引用类型
    private String name;
    //基础数据类型
    private int age;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

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
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Student{" +
                "subject=" + subject +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
