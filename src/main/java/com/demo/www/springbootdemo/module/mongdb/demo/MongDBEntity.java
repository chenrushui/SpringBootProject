package com.demo.www.springbootdemo.module.mongdb.demo;

/**
 * Created on 2019/10/21 9:53
 * author:crs
 * Description:
 */
public class MongDBEntity {
    private Integer id;
    private Integer age;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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
        return "MongDBEntity{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
