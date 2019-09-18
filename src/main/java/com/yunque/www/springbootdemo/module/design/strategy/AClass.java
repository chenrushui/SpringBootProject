package com.yunque.www.springbootdemo.module.design.strategy;

/**
 * Created on 2019/9/9 15:49
 * author:crs
 * Description:A类对B类进行包装。
 */
public class AClass {

    //todo：方式一：Spring帮助我们实例化对象
    //@Autowired
    private BClass b;

    /**
     * B调用它本身处理
     * @param name
     */
    public void process(String name) {
        b.process(name);
    }

    public BClass getB() {
        return b;
    }

    public void setB(BClass b) {
        this.b = b;
    }
}
