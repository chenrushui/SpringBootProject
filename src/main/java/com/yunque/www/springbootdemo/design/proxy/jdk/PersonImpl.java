package com.yunque.www.springbootdemo.design.proxy.jdk;

import lombok.extern.slf4j.Slf4j;

/**
 * Created on 2019/4/8.
 * author:crs
 * Description:PersonImpl
 */
@Slf4j
public class PersonImpl implements IPerson {
    @Override
    public void say(String message) {
        log.info(message);
    }
}
