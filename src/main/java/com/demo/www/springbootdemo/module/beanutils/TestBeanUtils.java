package com.demo.www.springbootdemo.module.beanutils;

import com.esotericsoftware.reflectasm.MethodAccess;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 2020/1/14 10:06
 * author:crs
 * Description:TestBeanUtils
 */
public class TestBeanUtils {

    //BeanUtils.copyProperties() 底层是通过反射进行属性值的复制
    //PropertyUtils.copyProperties()

    private static Map<Class, MethodAccess> methodMap = new HashMap<Class, MethodAccess>();
    private static Map<String, Integer> methodIndexMap = new HashMap<String, Integer>();
    private static Map<Class, List<String>> fieldMap = new HashMap<Class, List<String>>();


    public static void main(String[] args) {
        BeanEntity beanEntity = new BeanEntity();
        beanEntity.setName("BeanUtilsByReflect");
        beanEntity.setAge(100);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            //BeanEntity result = transferObjectByReflect(beanEntity, BeanEntity.class);
            copyProperties(beanEntity, new BeanEntity());
        }
        long end = System.currentTimeMillis();
        //旧的反射系统：2154
        System.out.println(end - start);


        //BeanEntity beanEntityASM = new BeanEntity();
        //使用reflectasm生产User访问类
        //MethodAccess methodAccess = MethodAccess.get(BeanEntity.class);
        //invoke()方法，执行指定的方法，某个对象，方法名，参数；如果参数为空，直接为null；
        //methodAccess.invoke(beanEntityASM, "setName", "张三");
        //String name = (String) methodAccess.invoke(beanEntityASM, "getName", null);
        //System.out.println(name);

        //invoke()方法，执行指定的方法，某个对象，方法名，参数；如果参数为空，直接为null；
        //通过类的Class对象创建对象
        //MethodAccess,返回当前对象的MethodAccess类，主要用于操作当前对象。
        //如何获取一个当前对象的MethodAccess对象？
        //ASM:Java字节码操控框架,可以大幅度提高反射的性能。二进制字节码操作类
        //把类当做一个数组，方法的位置就是索引。MethodAccess的作用：获取某个方法在类中的索引。把类当做数组。
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

    /**
     * 属性copy类原理
     *
     * @param target 目标
     * @param source 源对象
     */
    public static void copyProperties(Object target, Object source) {
        //获取指定对象的MethodAccess
        MethodAccess targetMethodAccess = methodMap.get(target.getClass());
        if (targetMethodAccess == null) {
            //这行代码是做什么的？
            targetMethodAccess = cache(target);
        }
        MethodAccess sourceMethodAccess = methodMap.get(source.getClass());
        if (sourceMethodAccess == null) {
            sourceMethodAccess = cache(source);
        }

        //获取所有的字段集合
        List<String> fieldList = fieldMap.get(source.getClass());
        for (int i = 0; i < fieldList.size(); i++) {
            String getKey = source.getClass().getName() + "." + "get" + fieldList.get(i);
            String setkey = target.getClass().getName() + "." + "set" + fieldList.get(i);
            Integer setIndex = methodIndexMap.get(setkey);

            if (setIndex != null) {
                int getIndex = methodIndexMap.get(getKey);
                // 参数一需要反射的对象
                // 参数二class.getDeclaredMethods 对应方法的index
                // 参数对三象集合

                //获取原对象的值
                Object obj = sourceMethodAccess.invoke(source, getIndex);

                //把值设置到目标对象的属性上
                targetMethodAccess.invoke(target, setIndex.intValue(), obj);
            }

        }
    }

    // 单例模式
    private static MethodAccess cache(Object orgi) {
        synchronized (orgi.getClass()) {
            MethodAccess methodAccess = MethodAccess.get(orgi.getClass());
            //获取当前对象的公共的字段
            Field[] fields = orgi.getClass().getDeclaredFields();
            //创建集合的时候，指定集合的长度，防止集合扩容。
            ArrayList<String> fieldList = new ArrayList<>(fields.length);
            for (Field field : fields) {
                //如果当前属性的访问修饰符是私有或者静态(//是否是私有的，是否是静态的;私有才会有get和set方法)
                if (Modifier.isPrivate(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                    //驼峰命名法，首字母大写，获取属性名称
                    String fieldName = StringUtils.capitalize(field.getName());
                    //获取get方法的索引或者说下标
                    int getIndex = methodAccess.getIndex("get" + fieldName);
                    // 获取set方法的下标
                    int setIndex = methodAccess.getIndex("set" + fieldName);
                    //获取当前class的类名，// 将类名get方法名，方法下标注册到map中
                    methodIndexMap.put(orgi.getClass().getName() + "." + "get" + fieldName, getIndex);
                    methodIndexMap.put(orgi.getClass().getName() + "." + "set" + fieldName, setIndex);
                    // 将属性名称放入集合里
                    fieldList.add(fieldName);
                }
            }
            //将类名、属性名称注册到map中
            fieldMap.put(orgi.getClass(), fieldList);
            methodMap.put(orgi.getClass(), methodAccess);
            return methodAccess;
        }
    }
}
