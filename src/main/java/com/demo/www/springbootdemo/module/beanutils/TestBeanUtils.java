package com.demo.www.springbootdemo.module.beanutils;

import org.springframework.beans.BeanUtils;

import javax.swing.plaf.synth.SynthScrollBarUI;
import java.lang.reflect.Method;

/**
 * Created on 2020/1/14 10:06
 * author:crs
 * Description:TestBeanUtils
 */
public class TestBeanUtils {

    //BeanUtils.copyProperties()
    //PropertyUtils.copyProperties()

    public static void main(String[] args) {
        BeanEntity beanEntity = new BeanEntity();
        beanEntity.setName("BeanUtilsByReflect");
        beanEntity.setAge(100);
        long start = System.currentTimeMillis();
        for (int i = 0; i <1000000 ; i++) {
            //BeanEntity result = transferObjectByReflect(beanEntity, BeanEntity.class);
        }
        long end = System.currentTimeMillis();
        //旧的反射系统：2154
        System.out.println(end-start);

        long l = System.currentTimeMillis();
        System.out.println(l-1578982737274L);


//        37493l;  1001001001110101


    }


    /**
     * 属性赋值的原理,通过反射实现
     *
     * @param obj    对象
     * @param zClass 对象的类型
     * @param <T>    返回的泛型类型
     * @return
     */
    public static <T> T transferObjectByReflect(Object obj, Class zClass) {
        T result = null;
        try {
            result = (T) zClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        if (obj != null && !obj.equals("")) {
            //获取所有的方法数组
            Method[] methods = obj.getClass().getMethods();
            Method method;
            for (int i = 0; i < methods.length; i++) {
                method = methods[i];
                try {
                    //如果是set方法
                    if (method.getName().startsWith("set")) {
                        //获取当前字段的名称
                        String fieldName = method.getName().replace("set", "");
                        Method method1 = result.getClass().getMethod(method.getName(), method.getParameterTypes());
                        Method getMethod = obj.getClass().getMethod("get" + fieldName, new Class[]{});
                        method1.invoke(result, getMethod.invoke(obj, new Object[]{}));
                    }
                } catch (Exception e) {
                    continue;
                }
            }
        }
        return result;
    }


}
