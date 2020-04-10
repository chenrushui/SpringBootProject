package com.demo.www.springbootdemo.module.kafka.interfacecallback;

/**
 * Created on 2020/3/25 10:49
 * author:crs
 * Description:使用接口回调的地方
 */
public class ServiceProcess {

    private ITestCallBack iTestCallBack;
    private String str;

    public ServiceProcess(ITestCallBack iTestCallBack,String str) {
        this.iTestCallBack = iTestCallBack;
        this.str = str;
    }

    public void process(){
        iTestCallBack.callBack(str);
    }
}
