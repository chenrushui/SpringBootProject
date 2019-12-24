package com.demo.www.springbootdemo.module.design.prototype.demo1;

/**
 * Created on 2019/12/2 11:35
 * author:crs
 * Description:Subject
 */
public class Subject {

    private String name;

    public Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[Subject: " + this.hashCode() + ",name:" + name + "]";
    }


}
