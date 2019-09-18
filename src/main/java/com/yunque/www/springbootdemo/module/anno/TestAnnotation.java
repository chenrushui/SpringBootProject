package com.yunque.www.springbootdemo.module.anno;

import com.yunque.www.springbootdemo.module.anno.visitpermission.VisitPermission;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created on 2019/3/18.
 * author:crs
 * Description:XXX
 */
@MyClassAnnotation(sysName = "电商平台", id = 10, desc = "类注解")
public class TestAnnotation {
    @MyFieldAnnotation(name = "字段名称")
    private String name;


    @Anno01(value = "测试数据", schools = {"北大", "清华"})
    //@MyMethodAnnotation(methodDesc = "getElement方法")
    public String getElement() {
        return name;
    }

    @VisitPermission()
    public void testVisitPermission(long hospital_id){

    }


    /**
     * 通过反射解析注解内容
     *
     * @param args
     */
    public static void main(String[] args) throws NoSuchMethodException {
        //1)获取对应类的Class对象(哪些类上使用了注解)
        //2)获取对应类方法的Method对象（找到使用注解的Method对象）
        //3)获取方法上的注解(获取注解对象)
        //4)打印注解的属性值

        Class<TestAnnotation> zClass = TestAnnotation.class;
        Method method = zClass.getMethod("getElement");
        //获取方法上的注解对象
        Anno01 annotation = method.getAnnotation(Anno01.class);
        String[] schools = annotation.schools();
        for (String item : schools) {
            System.out.println(item);
        }
        System.out.println("-----------");

        //解析类上的注解
        //todo：获取注解对象
        MyClassAnnotation classAnnotation = zClass.getAnnotation(MyClassAnnotation.class);
        if (classAnnotation == null) {
            //todo:必须添加运行时生命周期，否可就获取不到
            return;
        }
        System.out.println(classAnnotation.desc() + classAnnotation.sysName() + classAnnotation.id());
        System.out.println("-----------");


        //获取方法上的注解
        Method[] declaredMethods = zClass.getDeclaredMethods();
        for (Method method1 : declaredMethods) {
            //如何获取方法的民称  method1.getName()
            Anno01 annotation1 = method1.getAnnotation(Anno01.class);
            if (annotation1 == null) {
                continue;
            }
            System.out.println(annotation1.value());
        }
        System.out.println("-----");

        //获取字段注解
        Field[] declaredFields = zClass.getDeclaredFields();
        for (Field item : declaredFields) {
            MyFieldAnnotation annotation1 = item.getAnnotation(MyFieldAnnotation.class);
            if (annotation1 == null) {
                continue;
            }
            System.out.println(annotation1.name());
        }
    }

}
