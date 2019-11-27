package com.demo.www.springbootdemo.module.hash;

/**
 * Created on 2019/11/27 10:52
 * author:crs
 * Description:一致性hash算法
 */
public class TestHash {

    public static void main(String[] args) {
        //获取某个字符串的hash值
        //String name=".........";
        //System.out.println(name.hashCode());

        CacheManage cacheManage = new CacheManage();

        cacheManage.initCacheNode(3);
        //集群中存在三个redis结点，cacheNodeList集合存储的是redis集群中结点的信息；
        //hash值是名称的hash值，也就是对名称取hash；
        //字符串不变，Hash值不变；
        //CacheNode{cacheName='node_0', cacheIP='192.168.1.100', hashValue=3254796595}
        //CacheNode{cacheName='node_1', cacheIP='192.168.1.101', hashValue=3254796596}
        //CacheNode{cacheName='node_2', cacheIP='192.168.1.102', hashValue=3254796597}


        cacheManage.putData("node_8");
        //当前数据会存储在哪个redis结点上，计算它的Hash并且进行比较
        //todo：这三个结点的hash值，不应该平分整个hash环么？

        //流程：
        //1、根据规矩规则，获取几个结点的Hash值；
        //2、获取当前数据key的hash值，然后与集合中结点的hash值进行比较，得到要存入结点的索引
        //3、把数据存入到指定的redis节点上，取值的时候也一样。

        //1、对字符串获取器hashcode，字符串不变，hash值不变。

    }


}
