package com.demo.www.springbootdemo.module.rabbitmq.demo1;

import com.demo.www.springbootdemo.module.rabbitmq.BaseMQEntity;
import com.demo.www.springbootdemo.module.rabbitmq.ConstantMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 2019/9/30 10:52
 * author:crs
 * Description:消息生产者
 */
//@Component
public class BaseMQProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //@Autowired
    //private AmqpTemplate amqpTemplate;

    public void pushMessage(BaseMQEntity entity) {
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(entity.getMessageId());
        rabbitTemplate.convertAndSend(ConstantMessage.NAME_EXCHANGE, ConstantMessage.NAME_ROUTE_KEY, entity,correlationData);
    }


}
