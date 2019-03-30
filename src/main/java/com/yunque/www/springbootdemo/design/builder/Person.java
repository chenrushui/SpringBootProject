package com.yunque.www.springbootdemo.design.builder;

/**
 * Created on 2018/10/10.
 * Author:crs
 * Description:Person类
 */
public class Person {
    private String name;
    private int age;
    private double height;
    private double weight;

    private Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.height = builder.height;
        this.weight = builder.weight;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    static class Builder {
        private String name;
        private int age;
        private double height;
        private double weight;


        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder height(double height) {
            this.height = height;
            return this;
        }

        public Builder weight(double weight) {
            this.weight = weight;
            return this;
        }

        /**
         * 把当前类的对象传递出去
         *
         * @return Person
         */
        public Person create() {
            return new Person(this);
        }

    }


}
