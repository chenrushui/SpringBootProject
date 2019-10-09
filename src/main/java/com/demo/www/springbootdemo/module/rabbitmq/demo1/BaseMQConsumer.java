package com.demo.www.springbootdemo.module.rabbitmq.demo1;


import com.demo.www.springbootdemo.module.rabbitmq.ConstantMessage;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * Created on 2019/9/30 11:02
 * author:crs
 * Description:消息消费者，从消息队列中拉取消息并消费
 */
@Component
public class BaseMQConsumer {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 每次有消息进来，就会回调此方法;
     * 消息队列声明，交换机声明，routeKey声明;
     * 参数由调用方传递给receive方法;
     * 消费者要监听哪个消息队列？@RabbitListener();
     *
     * @param entity
     * @param map
     * @param channel
     * @throws IOException
     */
    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = ConstantMessage.NAME_QUEUE, durable = "true"),
            exchange = @Exchange(value = ConstantMessage.NAME_EXCHANGE, type = "topic"), key = "order_route_key"
    ))
    @RabbitHandler
    public void receive(@Payload Order entity, @Headers Map<String, Object> map, Channel channel) throws IOException {
        logger.info("rabbitmq:收到消息开始消费");
        logger.info("rabbitmq:" + entity.toString());
        if (channel.isOpen()) {
            Long deliveryTag = (Long) map.get(AmqpHeaders.DELIVERY_TAG);
            //确认这条消息已经被消费。
            channel.basicAck(deliveryTag, false);
        }
    }


}
