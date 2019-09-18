package com.yunque.www.springbootdemo.utils;

import java.util.LinkedList;


public class LinkedListTest {

    //记录哪些用户点过赞
    LinkedList<LikeEntity> list = new LinkedList();
    //记录点赞总数
    int likeSum = 0;

    /**
     * 处理点赞逻辑
     *
     * @param userId
     * @param ArticalId
     * @return
     */
    public String processLike(Integer userId, Integer ArticalId) {
        LikeEntity likeEntity = new LikeEntity(userId, ArticalId);
        list.add(likeEntity);
        likeSum++;
        return "点赞成功!";

    }

    /**
     * 查询点赞总的数量
     *
     * @return
     */
    public Integer getLikeNum() {
        return likeSum;
    }

    /**
     * 把用户的点赞数据存储到数据库中
     */
    public void processSqlData() {
        if (list != null && list.size() > 0) {
            LikeEntity entity = list.getFirst();
            Integer articalId = entity.getArticalId();
            Integer userId = entity.getUserId();
            //执行sql语句
        }
    }


    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        //在头部增加元素
        list.addFirst(-1);
        //在尾部增加元素
        list.addLast(10);
        System.out.println(list);

        //对列：先进先出。
        //栈：先进后出。

        //在指定的位置增加数据
        list.add(1,0);
        System.out.println(list);

        // poll使用方法,获取并删除列表的第一个元素
        Integer poll = list.poll();
        System.out.println(poll);
        System.out.println(list);

        Integer pop = list.pop();
        System.out.println(pop);
        System.out.println(list);

        //getFirst()与getLast() 集合中的元素还存在
        System.out.println("第一个元素"+list.getFirst());
    }



}
