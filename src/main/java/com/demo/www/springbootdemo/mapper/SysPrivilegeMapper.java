package com.demo.www.springbootdemo.mapper;


import com.demo.www.springbootdemo.pojo.SysPrivilegeBean;

public interface SysPrivilegeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysPrivilegeBean record);

    int insertSelective(SysPrivilegeBean record);

    SysPrivilegeBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysPrivilegeBean record);

    int updateByPrimaryKey(SysPrivilegeBean record);
}