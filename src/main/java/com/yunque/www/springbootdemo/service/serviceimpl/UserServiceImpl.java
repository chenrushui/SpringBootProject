package com.yunque.www.springbootdemo.service.serviceimpl;

import com.yunque.www.springbootdemo.pojo.User;
import com.yunque.www.springbootdemo.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Override
    public User printUser(User user) {

//        if (user == null) {
//            throw new RuntimeException("参数为空！");
//        }
        System.out.println("用户名：---->" + user.getName());
        System.out.println("用户名：---->" + user.getPassword());
        return null;
    }
}
