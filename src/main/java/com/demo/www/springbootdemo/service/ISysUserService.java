package com.demo.www.springbootdemo.service;


import com.demo.www.springbootdemo.pojo.SysUserBean;
import com.demo.www.springbootdemo.pojo.SysUserRoleJoinBean;

/**
 * Created on 2019/3/25.
 * author:crs
 * Description:ISysUserService
 */
public interface ISysUserService {

    /**
     * 通过id获取用户信息
     *
     * @param id
     * @return
     */
    SysUserBean selectSysUserById(Long id);

    /**
     * 通过id获取用户信息以及角色信息
     *
     * @param id
     * @return
     */
    SysUserBean selectSysUserRoleById(Long id);

    /**
     * 通过id获取用户信息以及角色信息
     *
     * @param id
     * @return
     */
    SysUserRoleJoinBean selectSysUserRoleJoinById(Long id);
}
