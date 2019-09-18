package com.yunque.www.springbootdemo.module.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * map集合的遍历
 */
public class TestMapForEach {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("aaa", "111");
        map.put("bbb", "222");
        map.put("ccc", "333");
        map.put("ddd", "444");

        //map.keySet() 所有键的集合   map.values() 获取所有值的集合

        //遍历方式一
        for (String key : map.keySet()) {
            String value = map.get(key).toString();
            System.out.println(key + ":" + value);
        }

        //遍历方式二：迭代器遍历,获取一个迭代器对象
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            String key = entry.getKey();
            String value = entry.getValue().toString();
            System.out.println(key + ":" + value);
        }

        //遍历方式三：直接遍历所有的value值，但是不能遍历key
        for (Object m : map.values()) {
            System.out.println(m.toString());
        }

        //遍历方式四：集合循环遍历
        for (Map.Entry<String, Object> m : map.entrySet()) {
            String key = m.getKey();
            String value = m.getValue().toString();
            System.out.println(key+":"+value);
        }
    }

}
