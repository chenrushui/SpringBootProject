package com.yunque.www.springbootdemo.module.design.observer;

import java.util.Observable;

/**
 * Created on 2019/1/29.
 *
 * @author:crs Description:创建被观察者类
 */

public class NetWorkObservable extends Observable {
    public void postMessage(HospitalBean bean) {
        setChanged();
        //把参数传递进去，要不然会爆出空指针异常
        notifyObservers(bean);
    }
}
