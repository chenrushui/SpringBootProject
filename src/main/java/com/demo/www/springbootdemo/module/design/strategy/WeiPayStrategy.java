package com.demo.www.springbootdemo.module.design.strategy;

/**
 * Created on 2019/9/9 13:42
 * author:crs
 * Description:XXX
 */
public class WeiPayStrategy implements IPayStrategy {
    @Override
    public void pay(String params) {
        System.out.println("微信支付");
    }
}
