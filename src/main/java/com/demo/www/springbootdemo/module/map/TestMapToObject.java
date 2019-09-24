package com.demo.www.springbootdemo.module.map;

import java.util.Map;

/**
 * map集合与对象之间的转换
 */
public class TestMapToObject {

    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws IllegalAccessException, InstantiationException {
       if (map==null){
           return null;
       }
        Object obj = beanClass.newInstance();
//        org.apache.commons.beanutils.BeanUtils.populate(obj, map);
        return null;


    }
}
