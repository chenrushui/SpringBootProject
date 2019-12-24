package com.demo.www.springbootdemo.module.design.prototype.copy;

/**
 * Created on 2019/11/29 11:31
 * author:crs
 * Description:深拷贝
 */
public class Person implements Cloneable {

    private String sonName;
    private Son son;

    public Person() {
    }

    public Person(String sonName, Son son) {
        this.sonName = sonName;
        this.son = son;
    }

    // 自定义拷贝构造函数
//    public Person(Person p) {
//        this.sonName = p.sonName;
//        this.son = p.son;
//    }

    public String getSonName() {
        return sonName;
    }

    public void setSonName(String sonName) {
        this.sonName = sonName;
    }

    public Son getSon() {
        return son;
    }

    public void setSon(Son son) {
        this.son = son;
    }

    @Override
    public String toString() {
        return "Person{" +
                "sonName='" + sonName + '\'' +
                ", son=" + son +
                '}';
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person person1 = (Person) super.clone();
//        person1.son = (Son) son.clone();
        return person1;
    }
}
