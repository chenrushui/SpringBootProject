package com.yunque.www.springbootdemo.design.observer;

import java.util.Observable;

/**
 * Created on 2019/1/29.
 * @author:crs
 * Description:网络请求，接口数据回调
 * 换另一个写法，使用匿名对象也可以实现。
 * 观察者对象已经放入到被观察者中的集合列表里面。
 */

public class Customer2 implements BaseObserver {
    @Override
    public void update(Observable o, Object arg) {
//        Log.i(TAG, arg.toString());
    }
}
