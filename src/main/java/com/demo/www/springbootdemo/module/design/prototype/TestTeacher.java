package com.demo.www.springbootdemo.module.design.prototype;

/**
 * Created on 2018/10/10.
 * Author:crs
 * Description:测试原型模式
 */
public class TestTeacher {
    public static void main(String[] args) throws CloneNotSupportedException {

        /**
         * 两个不同的人，除了姓名不一样，其他三个属性都一样，
         * 用原型模式进行拷贝就会显得异常简单，这也是原型模式的应用场景之一。
         *
         * 一个对象需要提供给其他对象访问，而且各个调用者可能都需要修改其值时，
         * 可以考虑使用原型模式拷贝多个对象供调用者使用，即保护性拷贝。
         */
        Teacher p = new Teacher();
        p.setAge(18);
        p.setName("张三");
        p.setHeight(178);
        p.setWeight(65);
        System.out.println(p);
        System.out.println("-----------");

        Teacher p1 = (Teacher) p.clone();
        System.out.println(p1);
        System.out.println("-----------");

        p1.setName("李四");
        p1.setAge(88);
        System.out.println(p);
        System.out.println(p1);
    }
}
