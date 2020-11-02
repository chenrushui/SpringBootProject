package com.demo.www.springbootdemo.crs.design.facade.demo2;

public class ModuleB {
    //示意方法
    public void testB(){
        System.out.println("调用ModuleB中的testB方法");
    }

    /**
     * 提供给子系统外部使用的方法
     */
    public void b1(){};

    /**
     * 子系统内部模块之间相互调用时使用的方法
     */
    private void b2(){};
    private void b3(){};
}

