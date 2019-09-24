package com.demo.www.springbootdemo.module.rabbitmq.demo;

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
 * 消息确认机制
 */
@Component
public class MQProducer implements RabbitTemplate.ConfirmCallback {
    private Logger logger = LoggerFactory.getLogger(MQProducer.class);

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    MessageConverter messageConverter;

    /**
     * 消息确认机制
     *
     * @param correlationData
     * @param ack
     * @param cause
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (!ack) {
            String id = correlationData.getId();
            logger.error("消息id:{},发送确认失败", id, cause);
        }
    }

    /**
     * 发送消息
     *
     * @param exchange
     * @param topic
     * @param message
     */
    public void sendMessage(String exchange, String topic, Object message) {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setMessageConverter(messageConverter);
        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        CorrelationData correlationData = new CorrelationData(uuid);
        try {
            rabbitTemplate.convertAndSend(exchange, topic, message, correlationData);
        } catch (AmqpException e) {
            logger.error("发送消息失败，消息id，消息内容", uuid, message.toString());
        }
    }
}
