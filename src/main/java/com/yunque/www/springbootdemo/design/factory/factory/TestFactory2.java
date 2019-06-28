package com.yunque.www.springbootdemo.design.factory.factory;

import com.yunque.www.springbootdemo.design.factory.factory1.Fruit;

public class TestFactory2 {

    public static void main(String[] args) {
        //需要传入完整的包名和类型，否则会报类找不到的异常
        Fruit apple = FruitFactory.getInstance("com.yunque.www.springbootdemo.design.factory.factory1.Apple");
        if (apple != null) {
            apple.eat();
        }
        Fruit orange = FruitFactory.getInstance("com.yunque.www.springbootdemo.design.factory.factory1.Orange");
        if (orange != null) {
            orange.eat();
        }
    }
}
