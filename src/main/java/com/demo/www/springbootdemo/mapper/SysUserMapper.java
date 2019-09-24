package com.demo.www.springbootdemo.mapper;

import com.demo.www.springbootdemo.pojo.SysUserBean;
import com.demo.www.springbootdemo.pojo.SysUserRoleJoinBean;

public interface SysUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUserBean record);

    int insertSelective(SysUserBean record);

    SysUserBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserBean record);

    int updateByPrimaryKey(SysUserBean record);

    SysUserRoleJoinBean selectSysUserRoleJoinById(Long id);

}