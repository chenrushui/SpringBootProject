package com.demo.www.springbootdemo.module.listsort;


import java.util.*;

/**
 * Created on 2019/11/21 17:30
 * author:crs
 * Description:集合中的排序
 */
public class TestListSort {

    public static void main(String[] args) {

        //case：HashMap根据value值进行排序
        valueSort();



    }

    /**
     * HashMap根据value值进行排序
     */
    private static void valueSort() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("网二",1);
        map.put("张三",2);
        map.put("赵四",3);
        map.put("小柒",4);
        System.out.println("排序前");
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry: entries) {
            System.out.println(entry.getKey()+"--"+entry.getValue());
        }
        System.out.println("排序后");
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                //具体排序规则
                //按照value值，从小到大排序
                //return o1.getValue()-o2.getValue();

                //按照value值，从大到小排序
                //return o2.getValue()-o1.getValue();

                //按照key值，用compareTo()方法默认是从小到大排序
                //a按照字典顺序排列
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        for (Map.Entry s : list) {
            System.out.println(s.getKey()+"--"+s.getValue());
        }
    }


}
