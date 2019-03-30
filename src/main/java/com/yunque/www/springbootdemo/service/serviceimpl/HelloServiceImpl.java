package com.yunque.www.springbootdemo.service.serviceimpl;

import com.yunque.www.springbootdemo.service.IHelloService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public class HelloServiceImpl implements IHelloService {

    /**
     * 开启注解式事务
     *
     * @param id
     */
    @Transactional
    @Override
    public void getHelloData(Integer id) {

    }
}
