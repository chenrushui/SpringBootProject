package com.yunque.www.springbootdemo.rabbitmq;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created on 2019/3/22.
 * author:crs
 * Description:RabbitConfigEntity
 */
@PropertySource("classpath:config.properties")
@Configuration
@ConfigurationProperties(prefix = "rabbit")
@Data
public class RabbitConfigEntity {
    private String host;
    private int port;
    private String username;
    private String password;
    private String queue1;
    private String queue2;
}
