package com.demo.www.springbootdemo.module.design.facade;

/**
 * FacadeClass
 */
public class FacadeClass {

    public SubSystem1 subSystem1 = new SubSystem1Impl();
    public SubSystem2 subSystem2 = new SubSystem2Impl();

    public void action() {
        subSystem1.fun1();
        subSystem2.fun2();
    }
}
