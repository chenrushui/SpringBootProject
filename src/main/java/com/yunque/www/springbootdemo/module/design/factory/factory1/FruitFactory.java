package com.yunque.www.springbootdemo.module.design.factory.factory1;

/**
 * 工厂类 主要用于获取对象
 */
public class FruitFactory {

    public static Fruit getInstance(String fruitName) {
        Fruit fruit = null;
        if ("Apple".equals(fruitName)) {
            fruit = new Apple();
        } else if ("Orange".equals(fruitName)) {
            fruit = new Orange();
        }
        return fruit;
    }

}
