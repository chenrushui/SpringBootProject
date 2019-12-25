package com.demo.www.springbootdemo.module.redisclient1;

/**
 * Created on 2019/12/25 19:03
 * author:crs
 * Description:测试实体模型
 */
public class RedisEntity {
    private String name;
    private Integer age;

    public RedisEntity() {
    }

    public RedisEntity(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "RedisEntity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
