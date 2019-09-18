package com.yunque.www.springbootdemo.module.design.single;

/**
 * Created on 2018/9/26.
 * Author:crs
 * Description:使用静态内部类，实现单例模式
 */
public class SingleTon {

    private SingleTon() {

    }

    /**
     * 对外暴露公共方法
     *
     * @return SingleTon
     */
    public static SingleTon getInstance() {
        return SingleHolder.instance;
    }

    /**
     * 静态内部类
     */
    public static class SingleHolder {
        public static SingleTon instance = new SingleTon();
    }
}
