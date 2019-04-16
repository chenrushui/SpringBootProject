package com.yunque.www.springbootdemo.design.proxy.jdk.demo2;

import java.lang.reflect.Proxy;

/**
 * Created on 2019/4/11.
 * author:crs
 * Description:TestTimeHandler
 */
public class TestTimeHandler {
    public static void main(String[] args) {
        //1）被代理类，实现接口
        Move move = new Car();
        //2）代理类，实现InvocationHandler接口，重写invoke方法，在invoke中进行功能增强
        TimeHandler timeHandler = new TimeHandler(move);
        //3）生成代理对象：调用jdk的类生成代理对象
        Move proxyObject = (Move) Proxy.newProxyInstance(timeHandler.getClass().getClassLoader(), move.getClass().getInterfaces(), timeHandler);
        proxyObject.move();
    }
}
