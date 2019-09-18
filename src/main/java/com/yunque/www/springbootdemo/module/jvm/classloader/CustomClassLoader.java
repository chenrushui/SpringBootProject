package com.yunque.www.springbootdemo.module.jvm.classloader;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created on 2019/4/17.
 * author:crs
 * Description:CustomClassLoader
 * 并没有发现ClassLoader此类的抽象方法。
 * 自定义一个类加载器去进行类的加载。
 */
public class CustomClassLoader extends ClassLoader {
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
        InputStream is = getClass().getResourceAsStream(fileName);
        if (is == null) {
            return super.loadClass(name);
        }
        try {
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }
}
