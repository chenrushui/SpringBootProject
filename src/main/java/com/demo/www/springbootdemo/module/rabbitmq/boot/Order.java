package com.demo.www.springbootdemo.module.rabbitmq.boot;

import java.io.Serializable;

public class Order implements Serializable {
    private int id;
    private String messageId;
    private String msg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", messageId='" + messageId + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
