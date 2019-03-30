package com.yunque.www.springbootdemo.mapper;

import com.yunque.www.springbootdemo.pojo.SysUserBean;
import com.yunque.www.springbootdemo.pojo.SysUserRoleJoinBean;

public interface SysUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUserBean record);

    int insertSelective(SysUserBean record);

    SysUserBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserBean record);

    int updateByPrimaryKey(SysUserBean record);

    SysUserRoleJoinBean selectSysUserRoleJoinById(Long id);

}