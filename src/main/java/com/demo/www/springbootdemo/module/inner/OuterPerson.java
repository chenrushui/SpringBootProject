package com.demo.www.springbootdemo.module.inner;

/**
 * Created on 2020/3/25 13:23
 * author:crs
 * Description:静态内部类
 */
public class OuterPerson {

    private String name;
    private int age;

    public OuterPerson(Builder builder) {
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

    @Override
    public String toString() {
        return "OuterPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static class Builder {
        private String name;
        private int age;

        public Builder() {
        }

        public Builder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public OuterPerson builder() {
            return new OuterPerson(this);
        }

        public Builder getName() {
            return this;
        }

        public Builder setName(String name) {
            this.name=name;
            return this;
        }

        public Builder getAge() {
            return this;
        }

        public Builder setAge(int age) {
            this.age=age;
            return this;
        }
    }
}
