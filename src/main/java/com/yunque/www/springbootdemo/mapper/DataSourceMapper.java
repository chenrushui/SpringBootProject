package com.yunque.www.springbootdemo.mapper;

import com.yunque.www.springbootdemo.pojo.DataSourceEntity;

/**
 * Created on 2019/9/19 15:31
 * author:crs
 * Description:多数据源mapper
 */
public interface DataSourceMapper {

    DataSourceEntity getDoctorInfoById(int id);

    DataSourceEntity getDoctorInfoByName(String name);

}
