package com.demo.www.springbootdemo.module.rabbitmq.demo2;

import com.demo.www.springbootdemo.module.rabbitmq.BaseMQEntity;

import java.io.Serializable;

/**
 * Created on 2019/9/30 15:00
 * author:crs
 * Description:账户信息
 */
public class Account extends BaseMQEntity implements Serializable {
    private int id;
    private String msg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
