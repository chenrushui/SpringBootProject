package com.demo.www.springbootdemo.module.rabbitmq;

/**
 * Created on 2019/9/30 10:47
 * author:crs
 * Description:消息常量（可以在配置文件中进行配置么？）
 */
public interface ConstantMessage {

    //目的一：消息常量，希望在配置文件中进行配置并读取；
    //使用消息中间件，这三个是必须定义的
    String NAME_EXCHANGE = "order_exchange";
    String NAME_QUEUE = "order_queue";
    String NAME_ROUTE_KEY = "order_route_key";

    //如何让普通类，实现某一个接口就能拿到消息队列中的数据进行处理。解耦。

    //rabbitmq 如何发送对象

    //不通过配置，通过代码的形式如何使用rabbitMQ

    //如何使用后台管理工具。

    //一会执行跑几遍代码。


    //账户中台消息
    String NAME_EXCHANGE_ACCOUNT = "exchange_account";

    String NAME_QUEUE_REGISTER = "queue_register";
    String NAME_QUEUE_LOGIN = "queue_login";
    String NAME_QUEUE_LOGOUT = "queue_logout";

    String NAME_ACCOUNT_ROUTE_KEY = "account_route_key";


}
