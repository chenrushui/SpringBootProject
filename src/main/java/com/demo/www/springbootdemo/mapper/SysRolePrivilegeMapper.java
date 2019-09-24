package com.demo.www.springbootdemo.mapper;


import com.demo.www.springbootdemo.pojo.SysRolePrivilegeBean;

public interface SysRolePrivilegeMapper {
    int insert(SysRolePrivilegeBean record);

    int insertSelective(SysRolePrivilegeBean record);
}