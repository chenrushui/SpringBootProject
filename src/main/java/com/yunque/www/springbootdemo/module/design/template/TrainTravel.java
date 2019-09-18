package com.yunque.www.springbootdemo.module.design.template;

public class TrainTravel extends TravelTemplate {
    @Override
    void payTicket() {
        System.out.println("火车买票");

    }

    @Override
    void getTicket() {
        System.out.println("火车取票");

    }

    @Override
    void checkTicket() {
        System.out.println("火车检票");
    }
}
