package com.demo.www.springbootdemo.module.design.strategy;

/**
 * Created on 2019/9/9 14:08
 * author:crs
 * Description: 支付方式工具类
 */
public class PayStrategyUtils {
    /**
     * 通过全类名创建对象
     *
     * @param payMethod
     * @return
     */
    public static IPayStrategy getPayStrategy(String payMethod) {
        try {
            Class<?> aClass = Class.forName(payMethod);
            return (IPayStrategy) aClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 通过类的路径创建对象
     *
     * @param payType
     * @return
     */
    public static IPayStrategy getPayMethod(String payType) {
        String path = "com.yunque.www.springbootdemo.design.strategy." + payType.concat("PayStrategy");
        try {
            Class<?> aClass = Class.forName(path);
            IPayStrategy payStrategy = (IPayStrategy) aClass.getDeclaredMethod("getInstance").invoke(null, null);
            return payStrategy;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
