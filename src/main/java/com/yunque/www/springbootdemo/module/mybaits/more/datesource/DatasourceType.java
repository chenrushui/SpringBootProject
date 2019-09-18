package com.yunque.www.springbootdemo.module.mybaits.more.datesource;

/**
 * Created on 2019/9/18 11:02
 * author:crs
 * Description:数据源类型
 * 1)此类存储是不同数据库来源对应的type,为每个数据源配置一个type
 */
public interface DatasourceType {

    /**
     * 数据源为pica时，对应的数据类型
     */
    public static String pica="pica";
    /**
     * 数据库为test时，对应的数据源类型
     */
    public static String test="log";
}
