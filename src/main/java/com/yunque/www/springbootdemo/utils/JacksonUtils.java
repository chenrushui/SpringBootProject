package com.yunque.www.springbootdemo.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunque.www.springbootdemo.pojo.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created on 2019/3/30.
 * author:crs
 * Description:工具类
 * SimpleDateFormat类的使用
 * this(System.currentTimeMillis()); 内部源码，返回系统时间的毫秒值
 * 如果是反序列化，要知道反序列化的类型，是集合还是自定义class
 */

public class JacksonUtils {

    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setName("crs");
        user.setPassword("1111");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //user.setBirthday(format.parse("1996-10-01"));
        user.setBirthday(new Date());

        ObjectMapper mapper = new ObjectMapper();
        //todo：设置时间序列化的格式:仅仅是序列化
        //mapper.setDateFormat(format);

        //对象转json
        String result = mapper.writeValueAsString(user);
        System.out.println(result);
        //集合转json
        ArrayList<User> list = new ArrayList<>();
        list.add(user);
        String resULTList = mapper.writeValueAsString(list);
        System.out.println(resULTList);

        String str = "{\"name\":\"crs\",\"password\":\"1111\",\"birthday\":1553939852568}";
        //把字符串反序列化成class
        mapper.setDateFormat(format);
        User resultUser = mapper.readValue(str, User.class);
        Date birthday = resultUser.getBirthday();
        resultUser.setBirthday(birthday);
        System.out.println(resultUser.toString());

        //todo：new Date().getTime() 获取当前时间的毫秒值进行打印
        //todo: System.out.println(new Date()); 显示样式不太看得懂：Sat Mar 30 17:57:32 CST 2019
        //todo: JSONObject.toJSONString() 创建对象耗费了大量的时间；尽量避免创建多个对象。
        System.out.println(new Date().getTime());
    }

}
