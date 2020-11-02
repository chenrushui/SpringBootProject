package com.demo.www.springbootdemo.crs.bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * 测试布隆过滤器
 */
public class TestBloomFilter {

    //定义布隆过滤器的长度
    private static int total = 1000000;
    //创建布隆过滤器
    private static BloomFilter bloomFilter = BloomFilter.create(Funnels.integerFunnel(), total,0.0003);

    private static int index = 0;
    private static int count = 0;
    public static void main(String[] args) {
        for (int i = 0; i < total; i++) {
            //将数据添加到过滤器中
            bloomFilter.put(i);
        }

        //判断数据是否存在？
        for (int i = 0; i < total; i++) {
            if (!bloomFilter.mightContain(i)) {
                index++;
                System.out.println("有数据没检测到" + i);
            }
        }
        System.out.println("是否能够识别过滤器中数据："+index);
        //数据全部存在
        //测试另外的10000数据，看看过滤器的误杀情况？现在是都不存在与过滤器中。

        for (int i = total; i < total+10000; i++) {
            if ( bloomFilter.mightContain(i)){
                count++;
            }
        }
        System.out.println("误判的数据量"+count);  //286个数据，本来不存在，但是确判定存在了。

        //1，遍历这一百万个在过滤器中的数时，都被识别出来了。
        //2，一万个不在过滤器中的数，误伤了320个，错误率是0.03左右。

        //某个判断的执行时间
        long startTime = System.nanoTime(); // 获取开始时间
        //判断这一百万个数中是否包含29999这个数
        if (bloomFilter.mightContain(29999)) {
            System.out.println("命中了");
        }
        long endTime = System.nanoTime();   // 获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "纳秒");
        //结果是1毫秒都不到即可判断出是否存在，所占用的空间也比较小。
    }
}
