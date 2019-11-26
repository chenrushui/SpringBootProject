package com.demo.www.springbootdemo.module.localCache;

import java.io.Serializable;

/**
 * Created on 2019/10/10 19:32
 * author:crs
 * Description:缓存对象
 */
public class CacheEntity implements Serializable {
    private int id;
    private String name;
    private int age;
    private String like;

    public CacheEntity() {
    }

    public CacheEntity(int id, String name, int age, String like) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.like = like;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }
}
