package com.yunque.www.springbootdemo.module.anno;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created on 2019/3/18.
 * author:crs
 * Description:XXX
 */
public class ExecuteAnnotation {
    public static void main(String[] args) {
        // 获取类注解
        MyClassAnnotation myClassAnnotation = TestAnnotation.class.getAnnotation(MyClassAnnotation.class);
        if (myClassAnnotation == null) {
            return;
        }
        System.out.println("id = " + myClassAnnotation.id() + "&sysName=" + myClassAnnotation.sysName() + "&desc=" + myClassAnnotation.desc());
        System.out.println("**********************类注解****************************");
        System.out.println();

        // 获取方法注解
        TestAnnotation testAnnotation = new TestAnnotation();
        Method[] methods = testAnnotation.getClass().getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            // 获取该方法的解决
            MyMethodAnnotation myMethodAnnotation = method.getAnnotation(MyMethodAnnotation.class);
            // 无方法注解的话跳过
            if (myMethodAnnotation == null) {
                continue;
            }
            System.out.println("methodName = " + method.getName() + "&methodDesc=" + myMethodAnnotation.methodDesc());
        }
        System.out.println("**********************方法注解****************************");
        System.out.println();

        // 获取字段注解
        Field[] fields = TestAnnotation.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
            // 获取该字段的解决
            MyFieldAnnotation myFieldAnnotation = field.getAnnotation(MyFieldAnnotation.class);
            if (myFieldAnnotation == null) continue;
            System.out.println("fieldName=" + field.getName() + "&name=" + myFieldAnnotation.name());
        }
        System.out.println("**********************字段注解end****************************");
    }
}
