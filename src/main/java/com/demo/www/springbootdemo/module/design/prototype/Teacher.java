package com.demo.www.springbootdemo.module.design.prototype;

/**
 * Created on 2018/10/10.
 * Author:crs
 * Description:原型设计模式
 * 1)实现Cloneable接口
 * 2)在clone()方法里面处理业务逻辑
 */
public class Teacher implements Cloneable {
    private String name;
    private int age;
    private double height;
    private double weight;

    public Teacher() {
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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    /**
     * 这样做有什么作用？
     *
     * @return Object
     */
    @Override
    protected Object clone() {
        Teacher teacher = null;
        try {
            teacher = (Teacher) super.clone();
            teacher.name = this.name;
            teacher.weight = this.weight;
            teacher.height = this.height;
            teacher.age = this.age;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return teacher;
    }
}
