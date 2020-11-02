package com.demo.www.springbootdemo.crs.design.facade.demo1;

/**
 * 外观模式，日志模式
 */
public class TestFacade {
    public static void main(String[] args) {
        //子系统，门面，客户端
        FacadeClass facadeClass = new FacadeClass();
        facadeClass.find();
    }
}

