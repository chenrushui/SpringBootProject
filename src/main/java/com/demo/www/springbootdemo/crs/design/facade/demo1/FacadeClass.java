package com.demo.www.springbootdemo.crs.design.facade.demo1;

public class FacadeClass {

    public SubSystem1 subSystem1=new SubSystem1Impl();
    public SubSystem2 subSystem2=new SubSystem2Impl();

    public void find(){
        subSystem1.find();
        subSystem2.find();
    }
}
