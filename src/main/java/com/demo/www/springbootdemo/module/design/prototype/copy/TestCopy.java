package com.demo.www.springbootdemo.module.design.prototype.copy;

/**
 * Created on 2019/11/29 11:33
 * author:crs
 * Description:TestCopy
 */
public class TestCopy {

    public static void main(String[] args) throws Exception {
        //该person对象有两个成员，一个基本类型
        Son son = new Son(10);
        Person p1 = new Person("大海", son);

        //通过copy获取的独对象
//        Person p2 = new Person(p1);
//

        Person p2 = (Person) p1.clone();

//        //改变原有对象的值
        p1.setSonName("小海");    // 值类型   不可变对象
        p1.getSon().setAge(55);  //引用类型

        System.out.println("p1:" + p1); //大海，10，---->  //小海 55
        System.out.println("p2:" + p2); //大海，10，---->  //大海 55  值类型直接copy一份，修改原有的值对现在的值无影响。

    }
}
