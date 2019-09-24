package com.demo.www.springbootdemo.module.design.builder;

/**
 * Created on 2018/12/19.
 * Author:crs
 * Description:静态内部类
 * 如何进行
 */

public class Teacher {
    public String name;
    public int age;

    public Teacher(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
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

    public static class Builder {
        public String name;
        public int age;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        /**
         * 构建者模式的核心思想：
         * 1）在静态内部类中，对外提供获取外部类对象的方法；
         * 2）在创建外部类的对象时，把内部类传递进去，以便传入参数。
         * 3）在外部类中，提供构造方法，传递内部类对象，通过内部类对象给外部类的成员变量赋值。
         *
         * @return Teacher
         */
        public Teacher create() {
            return new Teacher(this);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
