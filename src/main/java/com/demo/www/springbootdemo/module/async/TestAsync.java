package com.demo.www.springbootdemo.module.async;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created on 2019/12/2 17:50
 * author:crs
 * Description:TestAsync，实现异步的方式有哪些？
 */

public class TestAsync {
    public static void main(String[] args) {

        //一、使用线程池
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程处理");
            }
        });

        //二、使用消息队列。mq
        //消息发送与消息接受

        //三、定时任务@Scheduled
        //<dependency>
        //    <groupId>org.quartz-scheduler</groupId>
        //    <artifactId>quartz</artifactId>
        //    <version>2.3.0</version>
        //</dependency>

        //四、guava的AsyncEventBus

    }
}
