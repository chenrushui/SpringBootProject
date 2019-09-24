package com.demo.www.springbootdemo.module.rabbitmq.boot;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Consumer1 {

    /**
     * 参数由调用方传递给receive方法
     * 消费者要监听哪个消息队列？@RabbitListener()
     *
     * @param order
     * @param map
     * @param channel
     * @throws Exception
     */
    @RabbitHandler
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = MQConstant.QUEUE, durable = "true"),
            exchange = @Exchange(value = MQConstant.EXCHANGE, durable = "true", type = "topic"),
            key = "order.*"
    ))
    public void receive(@Payload Order order, @Headers Map<String, Object> map, Channel channel) throws Exception {
        System.out.println("收到消息开始消费");
        System.out.println("订单详情:" + order.toString());
        //每次有消息进来，就会回调此方法，所以不用手动循环
        //告诉queue，消息已经被消费过了。
        if (channel.isOpen()) {
            Long deliveryTag = (Long) map.get(AmqpHeaders.DELIVERY_TAG);
            channel.basicAck(deliveryTag, false);
        }
    }
}
