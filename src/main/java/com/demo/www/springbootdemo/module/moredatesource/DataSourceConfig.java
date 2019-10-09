//package com.demo.www.springbootdemo.module.moredatesource;
//
//
//import com.alibaba.druid.pool.DruidDataSourceFactory;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
///**
// * Created on 2019/9/19 15:04
// * author:crs
// * Description:数据源配置类
// */
//
//@Configuration
//@PropertySource({"classpath:jdbc.properties"})
//public class DataSourceConfig {
//
//    @Value("${jdbc.username}")
//    private String jdbcUsername;
//
//    @Value("${jdbc.password}")
//    private String jdbcPassword;
//
//    @Value("${jdbc.url}")
//    private String jdbcUrl;
//
//    @Value("${jdbc.driver}")
//    private String jdbcDriver;
//
//    @Value("${jdbc2.username}")
//    private String jdbc2Username;
//
//    @Value("${jdbc2.password}")
//    private String jdbc2Password;
//
//    @Value("${jdbc2.url}")
//    private String jdbc2Url;
//
//    @Autowired
//    private Environment env;
//
//
//    //数据源1
//    @Bean
//    public DataSource devDataSource() throws Exception {
//        Properties props = new Properties();
//        props.put("driverClassName", jdbcDriver);
//        props.put("url", jdbcUrl);
//        props.put("username", jdbcUsername);
//        props.put("password", jdbcPassword);
//        return DruidDataSourceFactory.createDataSource(props);
//    }
//
//    //数据源2
//    @Bean
//    public DataSource testDataSource() throws Exception {
//        Properties props2 = new Properties();
//        props2.put("driverClassName", jdbcDriver);
//        props2.put("url", jdbc2Url);
//        props2.put("username", jdbc2Username);
//        props2.put("password", jdbc2Password);
//        return DruidDataSourceFactory.createDataSource(props2);
//    }
//
//    //DynamicDataSource
//    @Bean
//    @Primary
//    public DynamicDataSource dynamicDataSource(@Qualifier("devDataSource") DataSource devDataSource, @Qualifier("testDataSource") DataSource testDataSource) {
//        Map<Object, Object> targetDataSources = new HashMap<>();
//        targetDataSources.put(DataSourceType.DEV, devDataSource);
//        targetDataSources.put(DataSourceType.TEST, testDataSource);
//        //设置动态数据源以及默认数据源
//        DynamicDataSource dynamicDataSource = new DynamicDataSource();
//        dynamicDataSource.setTargetDataSources(targetDataSources);
//        dynamicDataSource.setDefaultTargetDataSource(testDataSource);
//        return dynamicDataSource;
//    }
//
//    //SqlSessionFactory
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("devDataSource") DataSource devDataSource, @Qualifier("testDataSource") DataSource testDataSource) throws Exception {
//        //如何创建一个SqlSessionFactory对象
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(this.dynamicDataSource(devDataSource, testDataSource));
//        sqlSessionFactoryBean.setTypeAliasesPackage("com.demo.www.springbootdemo.pojo");
//        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/*.xml"));
//        return sqlSessionFactoryBean.getObject();
//    }
//
//    //配置事务管理器
//    @Bean
//    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//}
