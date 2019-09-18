package com.yunque.www.springbootdemo.module.rabbitmq.boot;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接收消息
 */
@Component
public class Consumer2 {


    @RabbitListener(queues = MQConstant.QUEUE)
    @RabbitHandler()
    public void receiver() {

    }

}
