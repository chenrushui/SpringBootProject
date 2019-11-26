package com.demo.www.springbootdemo.module.redis.queue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.CountDownLatch;

/**
 * Created on 2019/10/29 17:53
 * author:crs
 * Description:配置文件
 */
@Configuration
public class RedisQueueConfig {
//
//    @Bean
//    RedisReceiver receiver(CountDownLatch latch) {
//        return new RedisReceiver(latch);
//    }
//
//    @Bean
//    CountDownLatch latch() {
//        return new CountDownLatch(1);
//    }
//
//    @Bean
//    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
//        return new StringRedisTemplate(connectionFactory);
//    }
//
//    @Bean
//    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
//        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.addMessageListener(listenerAdapter, new PatternTopic("chat"));
//        return container;
//    }
//
//    @Bean
//    MessageListenerAdapter listenerAdapter(RedisReceiver receiver) {
//        return new MessageListenerAdapter(receiver, "receiveMessage");
//    }

}
