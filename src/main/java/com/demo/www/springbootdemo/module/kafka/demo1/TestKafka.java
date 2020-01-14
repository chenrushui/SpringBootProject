package com.demo.www.springbootdemo.module.kafka.demo1;

import java.util.LinkedList;
import java.util.List;

/**
 * Created on 2020/1/6 16:13
 * author:crs
 * Description:TestPartition
 * 1)kafka的partition如何分布到不同的broker上。
 */
public class TestKafka {

    public static void main(String[] args) {
        //1)kafka的partition如何分布到不同的broker上。
        //kafka在实现分区分布到各个broker上的算法实现，可以通过创建topic，设置副本数验证
        //todo：分区均匀分布在不同的kafka broker上；
        //testPartition();

        //1)ConsumerGroup组和partition之间如何做负载均衡?
        testConsumerGroup();

        //问题：
        //两个brokers结点，一个topic对应四个分区，一个broker上有两个主分区，两个副本分区；
        //如果想要保证消息的顺序性，只设置一个partition即可，一个partition可以保证消息的顺序消费。
        //如果消费者的数量大于分区的数量，则某些消费者会处于等待状态。
        //多个分区之间的消费顺序无法进行保证。
        //副本数量不能大于brokers集群结点的数量。


        //3)案例：创建topic:user-info,3个分区，每个分区有2个副本

        //创建kafkaProducer
        //testCreateKafkaProducer();
    }

    private static void testConsumerGroup() {
        List<String> partitions = new LinkedList<>();
        partitions.add("p0");
        partitions.add("p1");
        partitions.add("p2");
        partitions.add("p3");

        List<String> consumers = new LinkedList<>();
        consumers.add("c1");
        consumers.add("c2");
        consumers.add("c3");
        consumers.add("c4");
        consumers.add("c5");
        consumers.add("c6");

        //四个分区，对应六个消费者；向上取整，计算每个消费者对应几个分区
        int sum = (int) Math.ceil(partitions.size() * 1.0 / consumers.size());
        System.out.println("每个消费者对应的分区数：" + sum);
        for (int i = 0; i < consumers.size(); i++) {
            System.out.println("消费者" + consumers.get(i) + "，对应的分区:");

            for (int j = 0; j < sum; j++) {
                //如果下标大于等于partitions的元素个数，break
                if (i * sum + j >= partitions.size()) {
                    break;
                }
                System.out.println(partitions.get(i * sum + j));
            }
        }
    }

    private static void testPartition() {
        //分区数
        LinkedList<Object> partitions = new LinkedList<>();
        //四个主分区
        partitions.add("p0");
        partitions.add("p1");
        partitions.add("p2");
        partitions.add("p3");
        //四个副本分区
        partitions.add("p0—duplicate");
        partitions.add("p1—duplicate");
        partitions.add("p2—duplicate");
        partitions.add("p3—duplicate");

        //kafka服务器集群
        LinkedList<Object> brokes = new LinkedList<>();
        brokes.add("broke1");
        brokes.add("broke2");
        //brokes.add("broke3");

        for (int i = 0; i < partitions.size(); i++) {
            //todo：分区数%服务器结点数量
            System.out.println("分区" + partitions.get(i) + "在:" + brokes.get(i % brokes.size()) + "的broker上");
        }

    }
}
