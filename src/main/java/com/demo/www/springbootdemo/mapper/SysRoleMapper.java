package com.demo.www.springbootdemo.mapper;


import com.demo.www.springbootdemo.pojo.SysRoleBean;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleBean record);

    int insertSelective(SysRoleBean record);

    SysRoleBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleBean record);

    int updateByPrimaryKey(SysRoleBean record);
}