package com.demo.www.springbootdemo.module.thread;

public class Task implements Runnable {

    //@Autowired自己需要的对象

    private String params;

    public Task(String params) {
        this.params = params;
    }

    @Override
    public void run() {
        //处理具体的异步耗时操作
    }
}
