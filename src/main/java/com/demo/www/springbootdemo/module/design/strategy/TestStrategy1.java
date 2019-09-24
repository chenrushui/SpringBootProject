package com.demo.www.springbootdemo.module.design.strategy;

/**
 * Created on 2019/9/9 14:01
 * author:crs
 * Description:测试策略模式
 */
public class TestStrategy1 {

    public static void main(String[] args) {
        //创建上下文对象
        PayStrategyContext context = new PayStrategyContext();
        //选择支付宝支付
        IPayStrategy payStrategy = null;
        //payStrategy = new AliPayStrategy();
        //payStrategy = new EBankPayStrategy();
        //payStrategy = new WeiPayStrategy();
        //payStrategy = PayStrategyUtils.getPayStrategy("com.yunque.www.springbootdemo.design.strategy.EBankPayStrategy");
        payStrategy = PayStrategyUtils.getPayMethod("Ali");
        context.setPayStrategy(payStrategy);
        context.executePay();
    }
}
