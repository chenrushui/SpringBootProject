package com.demo.www.springbootdemo.crs.design.facade.demo2;

import org.junit.Test;

//客户端角色类
public class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.test();
    }
}
