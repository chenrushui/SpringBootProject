package com.yunque.www.springbootdemo.module.rabbitmq.boot;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

//    @Autowired
//    private RabbitTemplate amqpTemplate;

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(Order order) throws Exception {
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(order.getMessageId());
        amqpTemplate.convertAndSend(MQConstant.EXCHANGE, MQConstant.ROUTING_KEY, order);
    }
}
