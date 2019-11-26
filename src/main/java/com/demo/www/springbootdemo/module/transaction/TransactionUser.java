package com.demo.www.springbootdemo.module.transaction;

/**
 * Created on 2019/11/25 13:21
 * author:crs
 * Description:事务模型类
 */
public class TransactionUser {
    private String id;
    private String name;
    private String pwd;

    public TransactionUser() {
    }

    public TransactionUser(String id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
