package com.yunque.www.springbootdemo.module.design.strategy;

/**
 * Created on 2019/9/9 13:44
 * author:crs
 * Description:XXX
 */
public class EBankPayStrategy implements IPayStrategy {
    @Override
    public void pay() {
        System.out.println("银联支付");
    }
}
