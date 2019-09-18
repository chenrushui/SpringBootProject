package com.yunque.www.springbootdemo.module.design.factory.demo1;

import com.yunque.www.springbootdemo.module.design.factory.factory1.Fruit;

/**
 * Created on 2019/9/5 10:52
 * author:crs
 * Description:测试工厂模式
 */
public class TestFactory {

    public static void main(String[] args) {

        //需要传入完整的包名和类型，否则会报类找不到的异常

        Fruit fruit = (Fruit) FactoryDemo.create("com.yunque.www.springbootdemo.design.factory.factory1.Apple");
        if (fruit != null) {
            fruit.eat();
        }

        Fruit fruitDemo = (Fruit)FactoryDemo.create("com.yunque.www.springbootdemo.design.factory.factory1.Orange");
        if (fruitDemo!=null){
            fruitDemo.eat();
        }
    }
}
