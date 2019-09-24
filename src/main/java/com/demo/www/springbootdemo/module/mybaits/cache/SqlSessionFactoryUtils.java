package com.demo.www.springbootdemo.module.mybaits.cache;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;


/**
 * Created on 2019/3/24.
 * author:crs
 * Description:SqlSessionFactoryUtils
 */
public class SqlSessionFactoryUtils {

    /**
     * 如何获取SqlSessionFactory对象?
     */
    private static SqlSessionFactory factory = null;

    static {
        try {
            InputStream inputStream = Resources.class.getResourceAsStream("classpath:mybatis/mybatisConfig.xml");
            factory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取SqlSession对象的静态方法
    public static SqlSession getSqlSession() {
        return factory.openSession();
    }

    //获取SqlSessionFactory的静态方法
    public static SqlSessionFactory getSqlSessionFactory() {
        return factory;
    }


}
