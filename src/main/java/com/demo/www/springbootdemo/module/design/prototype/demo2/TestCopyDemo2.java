package com.demo.www.springbootdemo.module.design.prototype.demo2;

/**
 * Created on 2019/12/2 13:37
 * author:crs
 * Description:TestCopyDemo2
 */
public class TestCopyDemo2 {

    public static void main(String[] args) throws CloneNotSupportedException {
        SubjectCopy1 deep1 = new SubjectCopy1("deep1");
        StudentCopy1 studentCopy1 = new StudentCopy1();
        studentCopy1.setSubject(deep1);
        studentCopy1.setName("name1");
        studentCopy1.setAge(20);

//        System.out.println(studentCopy1.toString());

        StudentCopy1 studentCopy2 = (StudentCopy1) studentCopy1.clone();
        studentCopy2.setName("name2");
        studentCopy2.setAge(30);
        SubjectCopy1 subject = studentCopy2.getSubject();
        subject.setName("deep2");
        studentCopy2.setSubject(subject);

        System.out.println(studentCopy1.toString());
        System.out.println(studentCopy2.toString());


    }



}
