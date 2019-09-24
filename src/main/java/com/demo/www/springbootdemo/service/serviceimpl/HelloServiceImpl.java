package com.demo.www.springbootdemo.service.serviceimpl;

import com.demo.www.springbootdemo.service.IHelloService;
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
