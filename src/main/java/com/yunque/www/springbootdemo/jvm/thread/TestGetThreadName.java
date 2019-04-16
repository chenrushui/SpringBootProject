package com.yunque.www.springbootdemo.jvm.thread;

import java.util.Map;

/**
 * Created on 2019/4/12.
 * author:crs
 * Description:打印线程名称
 */
public class TestGetThreadName {

    public static void main(String[] args) {
        //栈追踪StackTrace()
        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
        for (Map.Entry<Thread, StackTraceElement[]> en : map.entrySet()) {
            //获取线程对象
            Thread key = en.getKey();
            StackTraceElement[] value = en.getValue();
            System.out.println("Thread name is" + key.getName());
            for (StackTraceElement t : value) {
                System.out.println("\t" + t.toString());
            }
        }

    }
}
