package com.yunque.www.springbootdemo.anno;

/**
 * Created on 2019/3/18.
 * author:crs
 * Description:XXX
 */
@MyClassAnnotation(sysName = "电商平台", id = 10, desc = "类注解")
public class TestAnnotation {
    @MyFieldAnnotation(name = "字段名称")
    private String name;

    private int age;//无注解

    private String address;//无注解

    @MyMethodAnnotation(methodDesc = "getElement方法")
    public String getElement() {
        return name;
    }

    // 无方法注解  无实际意义
    public int getAgeElement() {
        return age;
    }

}
