package com.demo.www.springbootdemo.module.thread;


import java.util.concurrent.*;

public class AsynchronousTest extends Thread {




    //基于系统包java.util.concurrent实现的
    private ExecutorService executor = Executors.newFixedThreadPool(100);

    public void asynchronousTest() throws ExecutionException, InterruptedException {
//        executor.submit(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                int time=0;
//                for (int i = 0; i <1000 ; i++) {
//                    time+=i;
//                }
//                System.out.println(time);
//            }
//        });

//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(1);
//            }
//        });

//        Future future = executor.submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("开始执行");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        //如果任务结束执行则返回 null
//        System.out.println("是否执行结束"+future.get());

        Future future = executor.submit(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(1000);
                return "true";
            }
        });
        String result = (String) future.get();
        System.out.println(result);

    }
}
