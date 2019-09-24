package com.demo.www.springbootdemo.mapper;


import com.demo.www.springbootdemo.pojo.SysUserRoleBean;

public interface SysUserRoleMapper {
    int insert(SysUserRoleBean record);

    int insertSelective(SysUserRoleBean record);

    SysUserRoleBean selectUserRoleById(Long id);
}