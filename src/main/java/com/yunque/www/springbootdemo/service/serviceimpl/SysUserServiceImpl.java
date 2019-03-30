package com.yunque.www.springbootdemo.service.serviceimpl;

import com.yunque.www.springbootdemo.mapper.SysRoleMapper;
import com.yunque.www.springbootdemo.mapper.SysUserMapper;
import com.yunque.www.springbootdemo.mapper.SysUserRoleMapper;
import com.yunque.www.springbootdemo.pojo.SysRoleBean;
import com.yunque.www.springbootdemo.pojo.SysUserBean;
import com.yunque.www.springbootdemo.pojo.SysUserRoleBean;
import com.yunque.www.springbootdemo.pojo.SysUserRoleJoinBean;
import com.yunque.www.springbootdemo.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 2019/3/25.
 * author:crs
 * Description:SysUserServiceImpl
 */
@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;


    @Override
    public SysUserBean selectSysUserById(Long id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过用户id查询用户角色
     *
     * @param id
     * @return
     */
    @Override
    public SysUserBean selectSysUserRoleById(Long id) {
        SysUserBean sysUserBean = sysUserMapper.selectByPrimaryKey(id);
        SysUserRoleBean sysUserRoleBean = sysUserRoleMapper.selectUserRoleById(id);
        SysRoleBean sysRoleBean = sysRoleMapper.selectByPrimaryKey(sysUserRoleBean.getRoleId());
        sysUserBean.setSysRoleBean(sysRoleBean);
        return sysUserBean;
    }


    /**
     * 通过用户id查询用户角色 关联查询
     * todo：如何在mybatis中进行关联查询？
     *
     * @param id
     * @return
     */
    @Override
    public SysUserRoleJoinBean selectSysUserRoleJoinById(Long id) {
        SysUserRoleJoinBean sysUserBean = sysUserMapper.selectSysUserRoleJoinById(id);
        return sysUserBean;
    }


}
