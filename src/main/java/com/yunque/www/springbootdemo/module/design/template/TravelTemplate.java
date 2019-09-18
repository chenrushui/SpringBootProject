package com.yunque.www.springbootdemo.module.design.template;

/**
 * 模板类
 */
public abstract class TravelTemplate {
    //买票，取票，检票，等待出发
    abstract void payTicket();

    abstract void getTicket();

    abstract void checkTicket();

    void waitToGo() {
        System.out.println("等待出发！");
    }

    /**
     * 模板方法
     */
    public void travel() {
        payTicket();
        getTicket();
        checkTicket();
        waitToGo();
    }

}
