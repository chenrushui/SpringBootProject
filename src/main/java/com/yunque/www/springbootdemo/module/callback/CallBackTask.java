package com.yunque.www.springbootdemo.module.callback;

/**
 * 子线程
 */
public class CallBackTask {
    public CallBackBody body;

    public CallBackTask(CallBackBody body) {
        this.body = body;
    }

    /**
     * 开启一个子线程去执行任务
     */
    public void start(Object context) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    body.execute(context);
                } catch (Exception e) {
                    e.printStackTrace();
                    body.failure(context);
                }
                body.success(context);
            }
        }).start();
    }
}
