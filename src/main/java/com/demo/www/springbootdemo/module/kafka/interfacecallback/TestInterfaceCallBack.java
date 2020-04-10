package com.demo.www.springbootdemo.module.kafka.interfacecallback;

/**
 * Created on 2020/3/25 10:48
 * author:crs
 * Description:XXX
 */
public class TestInterfaceCallBack {


    public static void main(String[] args) {
        ServiceProcess serviceProcess = new ServiceProcess(new TestCallBack(),"测试数据");
        serviceProcess.process();
    }
}
