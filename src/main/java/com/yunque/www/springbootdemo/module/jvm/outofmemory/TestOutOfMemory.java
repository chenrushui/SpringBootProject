package com.yunque.www.springbootdemo.module.jvm.outofmemory;

import java.util.ArrayList;

/**
 * Created on 2019/4/11.
 * author:crs
 * Description:测试堆内存溢出
 */
public class TestOutOfMemory {
//    public static void main(String[] args) {
//        //Java堆中用于存储对象，通过不断创建对象的方式可以造成堆内存溢出.
//        //将对象放入list中，使GC Roots到对象之间有可达路径，防止垃圾回收机制清除new的对象。
//        ArrayList<Demo1> list = new ArrayList<>();
//        while (true) {
//            list.add(new Demo1());
//            System.out.println("11111");
//        }
//    }

    public static void main(String[] args) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArrayList<Demo1> list = new ArrayList<>();

        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(new Demo1());
            System.out.println("11111");
        }

    }
}
