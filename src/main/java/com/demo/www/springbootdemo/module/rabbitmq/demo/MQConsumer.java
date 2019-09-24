package com.demo.www.springbootdemo.module.rabbitmq.demo;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConsumer {

    private Logger logger = LoggerFactory.getLogger(MQConsumer.class);

    @Autowired
    public  ConnectionFactory connectionFactory;

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(MQConstant.EXCHANGE);
    }

    //todo:创建消息队列为什么要增加参数?
    @Bean
    public Queue queue() {
        return new Queue(MQConstant.QUEUE);
    }

    /**
     * 把三者进行绑定  三者之间的关系，又忘记了。
     *
     * @return
     */
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(directExchange()).with(MQConstant.ROUTING_KEY);

    }

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer() {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer(connectionFactory);
        simpleMessageListenerContainer.setMaxConcurrentConsumers(1);
        simpleMessageListenerContainer.setConcurrentConsumers(1);
        simpleMessageListenerContainer.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        simpleMessageListenerContainer.setQueueNames(MQConstant.QUEUE);
        simpleMessageListenerContainer.setMessageListener(new ChannelAwareMessageListener() {

            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
                //todo：下面处理具体的接口回调
                try {
                    String letter = new String(message.getBody());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                finally {
                    channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
                }
            }

        });
        return simpleMessageListenerContainer;
    }
}
