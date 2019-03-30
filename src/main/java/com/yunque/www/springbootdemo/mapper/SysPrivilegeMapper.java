package com.yunque.www.springbootdemo.mapper;


import com.yunque.www.springbootdemo.pojo.SysPrivilegeBean;

public interface SysPrivilegeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysPrivilegeBean record);

    int insertSelective(SysPrivilegeBean record);

    SysPrivilegeBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysPrivilegeBean record);

    int updateByPrimaryKey(SysPrivilegeBean record);
}