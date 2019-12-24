package com.demo.www.springbootdemo.module.async.demo1;

import org.springframework.web.context.request.async.DeferredResult;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created on 2019/12/19 16:26
 * author:crs
 * Description:DeferredResultQueue
 */
public class DeferredResultQueue {

    /**
     * 对消息队列的常用操作
     */

    //将请求放入队列
    //有序消息队列
    private static Queue<DeferredResult<Object>> queue = new ConcurrentLinkedQueue<DeferredResult<Object>>();


    /**
     * 将请求放入消息队列
     *
     * @param deferredResult
     */
    public static void save(DeferredResult<Object> deferredResult) {
        queue.add(deferredResult);
    }

    public static DeferredResult<Object> get() {
        return queue.poll();
    }




}
