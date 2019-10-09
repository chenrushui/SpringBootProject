package com.demo.www.springbootdemo.module.rabbitmq.demo1;

import com.demo.www.springbootdemo.module.rabbitmq.BaseMQEntity;

import java.io.Serializable;

/**
 * Created on 2019/9/30 10:46
 * author:crs
 * Description:订单消息体
 */
public class Order extends BaseMQEntity implements Serializable {
    private int id;

    private String messsage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", messsage='" + messsage + '\'' +
                ", messageId=" + messageId +
                '}';
    }
}
