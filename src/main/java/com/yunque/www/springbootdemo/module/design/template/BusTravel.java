package com.yunque.www.springbootdemo.module.design.template;

public class BusTravel extends TravelTemplate {
    @Override
    void payTicket() {
        System.out.println("汽车买票");

    }

    @Override
    void getTicket() {
        System.out.println("汽车取票");

    }

    @Override
    void checkTicket() {
        System.out.println("汽车检票");
    }
}
