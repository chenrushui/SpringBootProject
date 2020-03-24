package com.demo.www.springbootdemo.module.kafka.kafkaClient.utils;

/**
 * Created on 2020/3/23 14:15
 * author:crs
 * Description:kafka环境配置
 */
public enum Environment {

    //不同的环境对应的集群地址不同
    DEV("DEV", "192.168.140.101:9092,192.168.140.102:9092,192.168.140.103:9092"),
    TEST("TEST", "192.168.140.101:9092,192.168.140.102:9092,192.168.140.103:9092"),
    TEST1("TEST1", "192.168.140.101:9092,192.168.140.102:9092,192.168.140.103:9092"),
    TEST2("TEST2", "192.168.140.101:9092,192.168.140.102:9092,192.168.140.103:9092"),
    UAT("UAT", "192.168.130.100:9092,192.168.120.101:9092,192.168.120.102:9092"),
    PROD("PROD", "172.19.121.2:9092,172.19.121.3:9092,172.19.121.4:9092");

    private String dev;
    private String bootstrapServers;

    Environment(String dev, String bootstrapServers) {
        this.dev = dev;
        this.bootstrapServers = bootstrapServers;
    }

    public String getDev() {
        return dev;
    }

    public void setDev(String dev) {
        this.dev = dev;
    }

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    //静态常量
    interface BootstrapServers {
        String DEV = "192.168.140.101:9092,192.168.140.102:9092,192.168.140.103:9092";
        String TEST = "192.168.140.101:9092,192.168.140.102:9092,192.168.140.103:9092";
        String UAT = "192.168.130.100:9092,192.168.120.101:9092,192.168.120.102:9092";
        String PROD = "172.19.121.2:9092,172.19.121.3:9092,172.19.121.4:9092";
    }

}
