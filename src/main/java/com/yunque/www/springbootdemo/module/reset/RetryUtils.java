package com.yunque.www.springbootdemo.module.reset;

import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

/**
 * java中的重试机制
 * 技术落地： 通过什么实现重试机制？
 * 使用场景
 * 业务流程是什么？  如果代码执行过程中出现异常，就进行重试。
 */
public class RetryUtils {

    //通过try...catch...实现重试功能
//    public static void main(String[] args) {
//        try {
//            testRetry();
//        } catch (Exception e) {
//            testRetry();
//            e.printStackTrace();
//        }
//    }

    public static void testRetry() {
        System.out.println("执行重试代码");
        //第一次执行没成功，在重试一次。
        throw new RuntimeException();
    }

    //通过do-while实现重试
//    public static void main(String[] args) {
//        int maxRetryTime=5;
//        int time=0;
//        String result=null;
//        do{
//            time++;
//            try {
//                result = testRetry1();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }while(null==result&&time<maxRetryTime);
//    }

    public static String testRetry1() {
        System.out.println("执行重试代码");
        //操作成功返回字符串；操作失败返回null
        return null;
    }

    //通过spring-retry框架实现
    public static void main(String[] args) {
        final String params = "传入参数,可为任意类型，final修饰即可";
        RetryTemplate retryTemplate = new RetryTemplate();
        SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy();
        simpleRetryPolicy.setMaxAttempts(5);
        retryTemplate.setRetryPolicy(simpleRetryPolicy);

        try {
            retryTemplate.execute(new RetryCallback<Object, Throwable>() {

                @Override
                public Object doWithRetry(RetryContext retryContext) throws Throwable {
                    //开始重试
                    System.out.println(params);
                    testRetry();
                    return "此处可返回操作结果";
                }
            }, new RecoveryCallback<Object>() {
                @Override
                public Object recover(RetryContext retryContext) throws Exception {
                    //重试多次后都失败了,就会走到这个方法里面
                    System.out.println("都重试失败了");
                    return null;
                }
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
