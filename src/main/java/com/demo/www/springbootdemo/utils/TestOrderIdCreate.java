package com.demo.www.springbootdemo.utils;

/**
 * Created on 2019/12/12 11:43
 * author:crs
 * Description:订单唯一id生成
 */
public class TestOrderIdCreate {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(Math.abs("5641652".hashCode()));


        //1576122246904+业务类型+
        //1576122297657+商品类型+
        //13+2+9
    }


}
