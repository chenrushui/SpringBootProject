package com.demo.www.springbootdemo.crs.threadpoolexecutor;

import jodd.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class TestThreadPoolExecutor {

    public static void main(String[] args) {
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 6, 2, TimeUnit.SECONDS,
//                new ArrayBlockingQueue<Runnable>(1),
//                new ThreadPoolExecutor.AbortPolicy());
//
//        for (int i = 0; i < 8; i++) {
//            MyThread myThread = new MyThread();
//            threadPoolExecutor.execute(myThread);
//        }

        createThreadPool();
    }

    /**
     * 获取线程池
     */
    public void getThreadPool() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 2, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(1), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread();
            //线程池来执行这些线程
            threadPoolExecutor.execute(thread);
        }
        threadPoolExecutor.shutdown();

        ExecutorService service = Executors.newFixedThreadPool(10);
    }

    public void getThreadPool1() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 6, 2, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 8; i++) {
            Thread thread = new Thread();
            threadPoolExecutor.execute(thread);
        }
        threadPoolExecutor.shutdown();
    }

    public static void createThreadPool() {
        //1，线程创建工厂,可以自定义线程命名格式(为核心线程执行名称)
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").get();

        //2，ThreadPoolExecutor.AbortPolicy()如果任务数量超出线程池处理能力,抛出java.util.concurrent.RejectedExecutionException异常
        ExecutorService pool = new ThreadPoolExecutor(3, 6,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), threadFactory, new ThreadPoolExecutor.AbortPolicy());


        //3，执行线程
        for (int i = 0; i < 8; i++) {
            MyThread thread = new MyThread();
            //线程池来执行这些线程
            pool.execute(thread);
        }
        pool.shutdown();
    }
}
