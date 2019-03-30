package com.yunque.www.springbootdemo.rabbitmq.boot;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 2019/3/23.
 * author:crs
 * Description:消息接收者
 */
@Configuration
public class QueueReceiver {

//    @RabbitListener(queues = "springboot")
//    public void processMessage(String str) {
//        System.out.println(str);
//    }

}
