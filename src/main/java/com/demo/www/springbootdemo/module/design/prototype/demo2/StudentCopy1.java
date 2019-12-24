package com.demo.www.springbootdemo.module.design.prototype.demo2;

/**
 * Created on 2019/12/2 13:12
 * author:crs
 * Description:
 */
public class StudentCopy1 implements  Cloneable{
    private SubjectCopy1 subject;
    //基础数据类型
    private String name;
    private int age;

    public SubjectCopy1 getSubject() {
        return subject;
    }

    public void setSubject(SubjectCopy1 subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //浅拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

//    //深拷贝
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        StudentCopy1 studentCopy1 = (StudentCopy1) super.clone();
//        SubjectCopy1 subject = studentCopy1.getSubject();
//        studentCopy1.setSubject((SubjectCopy1) subject.clone());
//        return studentCopy1;
//    }
//
//    //深拷贝，更方便，三者选其一即可
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        StudentCopy1 studentCopy1 = new StudentCopy1();
//        studentCopy1.setAge(age);
//        studentCopy1.setName(name);
//        studentCopy1.setSubject(subject);
//        return studentCopy1;
//    }

    @Override
    public String toString() {
        return "StudentCopy1{" +
                "subject=" + subject +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

