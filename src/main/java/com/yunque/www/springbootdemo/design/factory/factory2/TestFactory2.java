package com.yunque.www.springbootdemo.design.factory.factory2;

import com.yunque.www.springbootdemo.design.factory.factory1.Fruit;
import com.yunque.www.springbootdemo.design.factory.factory1.FruitFactory;

import java.util.Properties;

public class TestFactory2 {

    public static void main(String[] args) throws Exception {
        Properties pro = Init.getPro();
        Fruit apple = FruitFactory.getInstance(pro.getProperty("apple"));
        //通过反射获取的对象，有可能不存在
        if (apple != null) {
            apple.eat();
        }
    }
}
