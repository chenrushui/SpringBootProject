//package com.yunque.www.springbootdemo.kafka;
//
//import com.pica.cloud.foundation.kafka.consumer.ISimpleConsumer;
//import com.pica.cloud.foundation.kafka.consumer.SimpleConsumer;
//
//public class TestKafkaSdkConsumer {
//    public static void main(String[] args) {
//        ISimpleConsumer<String,String> consumer = new SimpleConsumer<>("dev","group-11");
//        consumer.receive("test-dev", record -> {
//            System.out.println(record.key(String.class)+"--------"+record.value(String.class));
//        });
//}
//}
//
