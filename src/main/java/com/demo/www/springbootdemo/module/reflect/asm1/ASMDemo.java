package com.demo.www.springbootdemo.module.reflect.asm1;

import com.esotericsoftware.reflectasm.MethodAccess;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created on 2019/12/16 14:57
 * author:crs
 * Description:测试高性能返回
 */
public class ASMDemo {

    private String a;
    private Integer b;

    public ASMDemo() {
    }

    public ASMDemo(String a, Integer b) {
        this.a = a;
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public static void main(String[] args) {
        ASMDemo asmDemo = new ASMDemo();
        asmDemo.setA("ccc");
        asmDemo.setB(20);
        MethodAccess methodAccess = MethodAccess.get(ASMDemo.class);
        //传递当前对象，传递方法名，获取属性的值。
        Object obj = methodAccess.invoke(asmDemo, "getB");
        System.out.println(obj);


        Calendar calendar = Calendar.getInstance();
        /* HOUR_OF_DAY 指示一天中的小时 */
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
        System.out.println(calendar.getTime());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH");
        System.out.println("一个小时前的时间：" + df.format(calendar.getTime()));
        System.out.println("当前的时间：" + df.format(new Date()));


    }
}
