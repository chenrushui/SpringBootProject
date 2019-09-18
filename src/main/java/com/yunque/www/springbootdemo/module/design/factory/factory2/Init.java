package com.yunque.www.springbootdemo.module.design.factory.factory2;

import java.io.*;
import java.util.Properties;

/**
 * 通过配置文件的形式，创建工厂类的子类
 */

public class Init {
    public static Properties getPro() throws Exception {
        Properties properties = new Properties();
        File file = new File("fruit.properties");
        if (file.exists()) {
            properties.load(new FileInputStream(file));
        } else {
            properties.setProperty("apple", "Apple");
            properties.setProperty("orange", "Orange");
            properties.store(new FileOutputStream(file), "FRUIT CLASS");

        }
        return properties;

    }
}

