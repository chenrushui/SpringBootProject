package com.yunque.www.springbootdemo.mapper;


import com.yunque.www.springbootdemo.pojo.SysUserRoleBean;

public interface SysUserRoleMapper {
    int insert(SysUserRoleBean record);

    int insertSelective(SysUserRoleBean record);

    SysUserRoleBean selectUserRoleById(Long id);
}