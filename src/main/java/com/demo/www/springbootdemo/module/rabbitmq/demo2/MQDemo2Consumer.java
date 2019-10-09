package com.demo.www.springbootdemo.module.rabbitmq.demo2;

import com.demo.www.springbootdemo.module.rabbitmq.ConstantMessage;
import com.demo.www.springbootdemo.module.rabbitmq.demo.MQConstant;
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

/**
 * Created on 2019/9/30 14:43
 * author:crs
 * Description:消息接收者
 */
@Configuration
public class MQDemo2Consumer {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ConnectionFactory connectionFactory;

    /**
     * 精确匹配模式的交换机,指定交换机的名称
     *
     * @return
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(ConstantMessage.NAME_EXCHANGE_ACCOUNT);
    }

    /**
     * 指定消息队列的名称
     *
     * @return
     */
    @Bean
    public Queue queue() {
        return new Queue(ConstantMessage.NAME_QUEUE_LOGIN);
    }

    /**
     * 把消息队列和交换机进行绑定
     *
     * @param directExchange
     * @param queue
     * @return
     */
    @Bean
    public Binding binding(DirectExchange directExchange, Queue queue) {
        return BindingBuilder.bind(queue).to(directExchange).with(MQConstant.ROUTING_KEY);
    }

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer() {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer(connectionFactory);
        simpleMessageListenerContainer.setMaxConcurrentConsumers(2);
        simpleMessageListenerContainer.setConcurrentConsumers(1);
        simpleMessageListenerContainer.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        simpleMessageListenerContainer.setQueueNames(ConstantMessage.NAME_QUEUE_LOGIN);
        simpleMessageListenerContainer.setMessageListener(new ChannelAwareMessageListener() {

            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
                //todo：下面处理具体的接口回调
                try {
                    String letter = new String(message.getBody());
                    logger.info("消息内容："+letter);
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
