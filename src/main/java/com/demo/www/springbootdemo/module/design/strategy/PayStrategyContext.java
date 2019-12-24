package com.demo.www.springbootdemo.module.design.strategy;

/**
 * Created on 2019/9/9 13:45
 * author:crs
 * Description:负责调度，执行入口的上下文context
 */
public class PayStrategyContext {

    private IPayStrategy payStrategy;

    public PayStrategyContext() {
    }

    //执行支付的方法
    public void executePay(String params) {
        if (payStrategy == null) {
            throw new RuntimeException("支付策略未配置");
        }
        payStrategy.pay(params);
    }

    public IPayStrategy getPayStrategy() {
        return payStrategy;
    }

    public void setPayStrategy(IPayStrategy iPayStrategy) {
        this.payStrategy = iPayStrategy;
    }
}
