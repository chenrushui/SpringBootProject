//package com.yunque.www.springbootdemo.kafka.spring;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.SendResult;
//import org.springframework.util.concurrent.ListenableFuture;
//import org.springframework.util.concurrent.ListenableFutureCallback;
//
//public class TestKafkaProducer {
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(KafkaConfig.class);
//        KafkaTemplate<Integer, String> kafkaTemplate = (KafkaTemplate<Integer, String>) ctx.getBean("kafkaTemplate");
//        String data = "this is a test message";
//        ListenableFuture<SendResult<Integer, String>> send = kafkaTemplate.send("topic-test", 1, data);
//        send.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
//            public void onFailure(Throwable throwable) {
//            }
//            public void onSuccess(SendResult<Integer, String> integerStringSendResult) {
//            }
//        });
//    }
//}
