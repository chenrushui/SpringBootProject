package com.demo.www.springbootdemo.module.design.strategy;

/**
 * Created on 2019/9/9 14:01
 * author:crs
 * Description:测试策略模式
 */
public class TestStrategy1 {

    /**
     * 预下单方法
     * @param params 请求参数
     * @param type UC下单类型
     */
    public static void prepareOrder(String params, String type) {
        params = "预下单参数";
        type = "Ali";

        //创建上下文对象
        PayStrategyContext context = new PayStrategyContext();
        //创建预下单对象
        IPayStrategy payStrategy = PayStrategyUtils.getPayMethod(type);
        context.setPayStrategy(payStrategy);
        context.executePay(params);
    }

    //payStrategy = new AliPayStrategy();
    //payStrategy = new EBankPayStrategy();
    //payStrategy = new WeiPayStrategy();
    //payStrategy = PayStrategyUtils.getPayStrategy("com.yunque.www.springbootdemo.design.strategy.EBankPayStrategy");


}
