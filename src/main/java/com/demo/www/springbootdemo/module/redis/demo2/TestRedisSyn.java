package com.demo.www.springbootdemo.module.redis.demo2;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * Created on 2019/12/20 18:13
 * author:crs
 * Description:使用redis锁实现秒杀业务
 */
public class TestRedisSyn {

    public void testRedisSyn(int clientName,String clientList) {

        //redis中存储商品数量为(goodsNum:100)
        String key = "goodsNum";
        Jedis jedis = new Jedis("192.168.140.98", 6379);
        jedis.auth("redis密码");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                jedis.watch(key);
                System.out.println("顾客:" + clientName + "开始抢商品");
                System.out.println("当前商品的个数：" + jedis.get(key));
                //当前商品个数
                int prdNum = Integer.parseInt(jedis.get(key));
                if (prdNum > 0) {

                    //开启事务，返回一个事务控制对象
                    Transaction transaction = jedis.multi();
                    //预先在事务对象中装入要执行的操作
                    transaction.set(key, String.valueOf(prdNum - 1));
                    List<Object> exec = transaction.exec();
                    if (exec == null || exec.isEmpty()) {
                        //可能是watch-key被外部修改，或者是数据操作被驳回
                        System.out.println("悲剧了，顾客:" + clientName + "没有抢到商品");
                    } else {
                        //这个命令是做啥的。//抢到商品记录一下
                        jedis.sadd(clientList, clientName+"");
                        System.out.println("好高兴，顾客:" + clientName + "抢到商品");
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }finally {
                jedis.unwatch();
            }
        }

    }
}
