//package com.yunque.www.springbootdemo.kafka.spring;
//
//import org.springframework.kafka.annotation.KafkaListener;
//
//import java.util.concurrent.CountDownLatch;
//
//public class TestKafkaConsumer {
//
//
//    private final CountDownLatch latch1 = new CountDownLatch(1);
//
//
//    //默认spring-kafka会为每一个监听方法创建一个线程来向kafka服务器拉取消息
//    @KafkaListener(id = "test-kafka", topics = "topic-test")
//    public void listen(byte[] records) {
//        //do something here
//        this.latch1.countDown();
//    }
//
//}
