package com.demo.www.springbootdemo.module.callback;

/**
 * 测试接口异步回调
 */
public class TestCallBack {
    public static void main(String[] args) {

        Object context = "上下文信息";

        new CallBackTask(new CallBackBody() {
            @Override
            void execute(Object context) {
                System.out.println("开始执行耗时操作");
            }

            @Override
            void success(Object obj) {
                System.out.println("\n成功后的回调函数...");
                System.out.println(context);
            }

            @Override
            void failure(Object obj) {
                System.out.println("\n失败后的回调函数...");
                System.out.println(context);
            }
        }).start(context);

    }
}
