package com.yunque.www.springbootdemo.mapper;


import com.yunque.www.springbootdemo.pojo.SysRolePrivilegeBean;

public interface SysRolePrivilegeMapper {
    int insert(SysRolePrivilegeBean record);

    int insertSelective(SysRolePrivilegeBean record);
}