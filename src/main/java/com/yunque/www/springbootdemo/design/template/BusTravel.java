package com.yunque.www.springbootdemo.design.template;

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
