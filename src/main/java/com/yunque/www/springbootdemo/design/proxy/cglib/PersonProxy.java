package com.yunque.www.springbootdemo.design.proxy.cglib;

import lombok.extern.slf4j.Slf4j;

/**
 * Created on 2019/4/8.
 * author:crs
 * Description:PersonProxy
 */
@Slf4j
public class PersonProxy {
    public void say() {
        log.info("吃饭中");
    }
}
