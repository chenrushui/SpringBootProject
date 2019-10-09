package com.demo.www.springbootdemo.module.rabbitmq.demo2;

import com.demo.www.springbootdemo.module.rabbitmq.BaseMQEntity;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created on 2019/9/30 14:20
 * author:crs
 * Description:生产者
 */
@Component
public class MQDemo2Producer implements RabbitTemplate.ConfirmCallback {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RabbitTemplate rabbitTemplate;
    //消息转换器
    @Autowired
    private MessageConverter messageConverter;

    /**
     * 发送消息的方法
     *
     * @param entity
     */
    public void sendMessage(String exchangeName, String routeKey, BaseMQEntity entity) {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setMessageConverter(messageConverter);
        //使用uuid作为消息的唯一标识
        String messageId = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        CorrelationData correlationData = new CorrelationData(messageId);
        try {
            rabbitTemplate.convertAndSend(exchangeName, routeKey, entity, correlationData);
        } catch (AmqpException e) {
            //消息发送失败
            logger.error("消息发送失败,uuid" + messageId);
        }
    }


    /**
     * 消息确认机制，消息是否正常投递到exchange
     *
     * @param correlationData
     * @param ack
     * @param cause
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (!ack) {
            String id = correlationData.getId();
            logger.error("消息id:{},发送失败:",id,cause);
        }
    }
}
