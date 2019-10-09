package com.demo.www.springbootdemo.module.rabbitmq;

/**
 * Created on 2019/9/30 10:55
 * author:crs
 * Description:所有的消息模型都需要继承此类
 */
public class BaseMQEntity {

    public String messageId;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }


}
