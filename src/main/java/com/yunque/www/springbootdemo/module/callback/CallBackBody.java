package com.yunque.www.springbootdemo.module.callback;

/**
 * 抽象接口用于结果回调
 */
public abstract class CallBackBody {

    void success(Object obj) {
        System.out.println("成功！");
    }

    void failure(Object obj) {
        System.out.println("失败！");
    }

    //用于执行异步任务
    abstract void execute(Object context);

}
