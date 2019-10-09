//package com.demo.www.springbootdemo.module.moredatesource;
//
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//
///**
// * Created on 2019/9/18 10:57
// * author:crs
// * Description:mybatis 动态数据源的配置
// * 1)动态数据源,需要继承AbstractRoutingDataSource
// */
//public class DynamicDataSource extends AbstractRoutingDataSource {
//
//    private static String dataSourceType;
//
//    /**
//     * 返回数据源类型，让系统知道我用的是哪个数据源
//     *
//     * @return
//     */
//    @Override
//    protected Object determineCurrentLookupKey() {
//        return dataSourceType;
//    }
//
//
//    /**
//     * 设置数据源类型,在使用数据库之前自己调用该方法
//     *
//     * @param type 要使用的数据源类型
//     */
//    public static void setDataSourcesType(String type) {
//        dataSourceType = type;
//    }
//
//    /**
//     * 设置数据源集合类，参数是map集合，key就是我们定义的数据源类型，value就是数据源
//     *
//     * @param targetDataSources 多个数据源
//     */
////    @Override
////    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
////        super.setTargetDataSources(targetDataSources);
////    }
//
//    /**
//     * 设置默认数据源
//     *
//     * @param defaultTargetDataSource 默认数据源
//     */
////    @Override
////    public void setDefaultTargetDataSource(Object defaultTargetDataSource) {
////        super.setDefaultTargetDataSource(defaultTargetDataSource);
////    }
//}
