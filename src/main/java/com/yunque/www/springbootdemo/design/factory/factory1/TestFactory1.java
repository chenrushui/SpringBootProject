package com.yunque.www.springbootdemo.design.factory.factory1;

public class TestFactory1 {
    public static void main(String[] args) {
        Fruit apple = FruitFactory.getInstance("Apple");
        apple.eat();
        Fruit orange = FruitFactory.getInstance("Orange");
        orange.eat();
    }
}
