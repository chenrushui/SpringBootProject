package com.yunque.www.springbootdemo.design.proxy.jdk.demo3;

public class TestJDKProxy {
    public static void main(String[] args) {


        //IUserDao为当前接口创建动态代理对象
        IUserDao invoker = (IUserDao) new Invoke().getInstance(IUserDao.class);
        //调用接口中的方法
        System.out.println(invoker.getUserName());

    }
}
