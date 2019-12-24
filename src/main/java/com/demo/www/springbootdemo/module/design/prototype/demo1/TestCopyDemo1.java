package com.demo.www.springbootdemo.module.design.prototype.demo1;

/**
 * Created on 2019/12/2 11:37
 * author:crs
 * Description:TestCopyDemo1
 */
public class TestCopyDemo1 {
    public static void main(String[] args) throws CloneNotSupportedException {

        Subject subject1 = new Subject("subject1");
        Student studentA = new Student();
        studentA.setSubject(subject1);
        studentA.setName("studentA");
        studentA.setAge(20);
        //System.out.println(studentA.toString());
        // subject1   studentA  20

        //浅copy测试
        Student studentB = (Student) studentA.clone();
        studentB.setName("studentB");
        studentB.setAge(30);
        Subject subject2 = studentA.getSubject();
        subject2.setName("subject2");
        studentB.setSubject(subject2);

        System.out.println(studentA.toString());
        // subject2   studentB  20
        System.out.println(studentB.toString());
        // subject2   studentB  30
        //给Sting类型的变量赋值，就相当于指向了一个新的内存地址


    }
}
