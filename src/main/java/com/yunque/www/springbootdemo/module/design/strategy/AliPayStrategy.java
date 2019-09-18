package com.yunque.www.springbootdemo.module.design.strategy;

/**
 * Created on 2019/9/9 13:43
 * author:crs
 * Description:XXX
 */

public class AliPayStrategy implements IPayStrategy {

    public static AliPayStrategy aliPayStrategy;


    private AliPayStrategy() {
    }

    public static AliPayStrategy getInstance() {
        if (aliPayStrategy == null) {
            aliPayStrategy = new AliPayStrategy();
        }
        return aliPayStrategy;
    }


    @Override
    public void pay() {
        System.out.println("支付宝支付");
    }
}
