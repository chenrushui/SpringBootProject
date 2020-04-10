package com.demo.www.springbootdemo.module.kafka.interfacecallback;

/**
 * Created on 2020/3/25 10:48
 * author:crs
 * Description:XXX
 */
public class TestCallBack implements ITestCallBack {
    @Override
    public void callBack(String str) {
        System.out.println(str);
    }
}
