package com.demo.www.springbootdemo.module.transaction;

/**
 * Created on 2019/11/25 13:22
 * author:crs
 * Description:Mapper文件
 */
public interface TransactionUserDao {

    //插入数据库中
    void insert(TransactionUser u);

    //删除用户操作
    int deleteByPrimaryKey(int id);
}
