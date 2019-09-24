package com.demo.www.springbootdemo.module.redisclient.utils;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CacheResult<T> {

    //成员变量
    public List<T> result = null;

    public CacheResult(List<T> result) {
        this.result = result;
    }

    public T getFirst() {
        //返回集合中的第一个数据
        return this.result.get(0);
    }

    /**
     * 过滤器：过滤掉执行失败的结果
     *
     * @param predicate
     * @return
     */
    public CacheResult<T> filter(Predicate<? super T> predicate) {
        List<T> result = this.result.stream().filter(predicate).collect(Collectors.toList());
        if (result != null && result.size() > 0) {
            this.result = result;
        }
        return this;
    }

    //Predicate接口主要用来判断一个参数是否符合要求,类似于Junit的assert.
    //result.stream() 响应式编程或者函数式编程，对数据进行处理.

}
