package com.yunque.www.springbootdemo.rabbitmq.boot;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 2019/3/23.
 * author:crs
 * Description:消息队列
 */
@Configuration
public class QueueConf {

    //配置文件，配置bean，如果想要创建对象，两个必须结合使用

    @Bean
    public Queue queue() {
        return new Queue("springboot");
    }

}
