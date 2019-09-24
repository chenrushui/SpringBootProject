//package com.yunque.www.springbootdemo.kafka;
//
//import org.apache.kafka.clients.admin.AdminClient;
//import org.apache.kafka.clients.admin.CreateTopicsResult;
//import org.apache.kafka.clients.admin.NewTopic;
//
//import java.util.ArrayList;
//import java.util.Properties;
//import java.util.concurrent.ExecutionException;
//
//public class TestKafka {
//    public static void main(String[] args) {
//        Properties props = new Properties();
//        props.put("bootstrap.servers", "192.168.140.101:9092,192.168.140.102:9092,192.168.140.103:9092");
//        AdminClient adminClient = AdminClient.create(props);
//        ArrayList<NewTopic> topics = new ArrayList<NewTopic>();
//        NewTopic newTopic = new NewTopic("topic-test", 1, (short) 1);
//        topics.add(newTopic);
//        CreateTopicsResult result = adminClient.createTopics(topics);
//        try {
//            result.all().get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//
//        //1)使用AdminClient API可以来对kafka服务器进行配置
//        //2)创建了一个名为“topic-test”，分区数为1，复制因子为1的Topic.
//        //创建Topic
//        //kafka服务器的地址
//        //每个参数什么意思？
//
//
//    }
//}
