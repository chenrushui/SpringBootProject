package com.yunque.www.springbootdemo.utils;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunque.www.springbootdemo.pojo.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created on 2019/3/30.
 * author:crs
 * Description:工具类
 * SimpleDateFormat类的使用
 * this(System.currentTimeMillis()); 内部源码，返回系统时间的毫秒值
 * 如果是反序列化，要知道反序列化的类型，是集合还是自定义class
 */

public class JacksonTestUtils {

    public static void main(String[] args) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put("k" + i, "v" + i);
        }

        User user = new User("crs", "123456", new Date());
        System.out.println(map.size());
        ObjectMapper mapper = new ObjectMapper();

        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            mapper.writeValueAsString(user);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("Jackson：" + (end1 - start1) / 10);

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            JSONObject.toJSONString(user);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("FastJson：" + (end2 - start2) / 10);

        //todo:序列化小的对象，确实很快jackson；
        //todo:多次执行，计算平均时间（不能计算单个特例）
        //todo：一个对象的大小，一个集合的大小

//        long end1 = System.currentTimeMillis();
//        System.out.println("Jackson：" + (end - start));
//        System.out.println("FastJson：" + (end1 - end));
//        mapper.writeValueAsString(map);
    }

}
