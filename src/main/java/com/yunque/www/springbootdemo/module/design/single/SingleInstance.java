package com.yunque.www.springbootdemo.module.design.single;

/**
 * Created on 2018/9/25.
 * Author:crs
 * Description:使用静态内部类，实现单例模式
 */
public class SingleInstance {

    private SingleInstance() {
    }

    public static SingleInstance getInstance() {
        return SingleHolder.instance;
    }

    private static class SingleHolder {
        private static SingleInstance instance = new SingleInstance();
    }


}
