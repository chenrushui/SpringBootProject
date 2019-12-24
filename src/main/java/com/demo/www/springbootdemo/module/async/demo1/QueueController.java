package com.demo.www.springbootdemo.module.async.demo1;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;

/**
 * Created on 2019/12/23 13:23
 * author:crs
 * Description:异步消息队列的使用
 */

@RestController
public class QueueController {


    @GetMapping("/createOrder")
    public DeferredResult<Object> createOrder() {
        //如果三秒内没有执行成功，则请求失败
        DeferredResult deferredResult = new DeferredResult((long) 10000, "create fail...");
        DeferredResultQueue.save(deferredResult);
        return deferredResult;
    }

    //当执行这个请求时 setresult方法会执行 createOrder请求才会返回


    @GetMapping("/create")
    public String create() {
        //创建订单
        String order = UUID.randomUUID().toString();
        DeferredResult<Object> deferredResult = DeferredResultQueue.get();
        deferredResult.setResult(order);
        return "success===>" + order;
    }

}
