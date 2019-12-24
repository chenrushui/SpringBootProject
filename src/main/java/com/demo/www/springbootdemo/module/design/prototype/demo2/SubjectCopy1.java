package com.demo.www.springbootdemo.module.design.prototype.demo2;

/**
 * Created on 2019/12/2 13:13
 * author:crs
 * Description:SubjectCopy1
 */
public class SubjectCopy1 implements  Cloneable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SubjectCopy1(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //Subject 如果也有引用类型的成员属性，也应该和 Student 类一样实现
        return super.clone();
    }

    @Override
    public String toString() {
        return "SubjectCopy1{" +
                "name='" + name + '\'' +
                '}';
    }
}
