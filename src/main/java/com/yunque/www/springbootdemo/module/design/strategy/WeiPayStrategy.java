package com.yunque.www.springbootdemo.module.design.strategy;

/**
 * Created on 2019/9/9 13:42
 * author:crs
 * Description:XXX
 */
public class WeiPayStrategy implements IPayStrategy {
    @Override
    public void pay() {
        System.out.println("微信支付");
    }
}
