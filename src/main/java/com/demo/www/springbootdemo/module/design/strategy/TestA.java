package com.demo.www.springbootdemo.module.design.strategy;

/**
 * Created on 2019/9/9 16:20
 * author:crs
 * Description:XXX
 */
public class TestA {

    public static void main(String[] args) {
        AClass a = new AClass();
        //方式二：手动创建B类的对象，并传递到A类中
        BClass b = new BClass();
        a.setB(b);
        a.process("crs");

        /**
         * A类是对B类的包装，持有B类对象的引用；A类可以处理多种不同的业务逻辑，增强B的功能。
         * B类的实例化有两种方式;
         * 这样代码更具备专业性，方便解耦;
         * 通过策略模式替换if...else... 代码优雅;
         * switch...case 替代if...else...;
         * 把相似性操作或者策略封装起来;
         * 设计模式：语法近似，语义不同，使用场景不同。
         *
         */
    }
}
