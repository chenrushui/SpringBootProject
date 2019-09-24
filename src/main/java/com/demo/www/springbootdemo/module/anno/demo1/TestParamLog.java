package com.demo.www.springbootdemo.module.anno.demo1;

public class TestParamLog {

    @ParamLog
    public  int addSum(int a, int b) {
        return a + b;
    }
}
