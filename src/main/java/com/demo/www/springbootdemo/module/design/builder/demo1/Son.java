package com.demo.www.springbootdemo.module.design.builder.demo1;

/**
 * 构建者模式
 */
public class Son {

    private int height;
    public int weight;
    private int age;
    private String name;

    public Son(Builder builder) {
        this.height = builder.height;
        this.weight = builder.weight;
        this.age = builder.age;
        this.name = builder.name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Son{" +
                "height=" + height +
                ", weight=" + weight +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

   public static class Builder {
        private int height;
        public int weight;
        private int age;
        private String name;

        public int getHeight() {
            return height;
        }

        public Builder setHeight(int height) {
            this.height = height;
            return this;
        }

        public int getWeight() {
            return weight;
        }

        public Builder setWeight(int weight) {
            this.weight = weight;
            return this;
        }

        public int getAge() {
            return age;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public String getName() {
            return name;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Son create() {
            return new Son(this);
        }
    }
}
