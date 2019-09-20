//package com.yunque.www.springbootdemo.module.design.factory.factory;
//
//import com.yunque.www.springbootdemo.module.design.factory.factory1.Fruit;
//
///**
// * 使用反射机制，实现工厂模式
// */
//public class FruitFactory {
//    public static Fruit getInstance(String className) {
//        Fruit fruit = null;
//        try {
//            fruit = (Fruit) Class.forName(className).newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return fruit;
//    }
//
//}
