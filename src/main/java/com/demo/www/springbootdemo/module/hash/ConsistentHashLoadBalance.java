package com.demo.www.springbootdemo.module.hash;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created on 2019/11/27 14:11
 * author:crs
 * Description:一致性哈希算法
 */
public class ConsistentHashLoadBalance {
    private TreeMap<Long, String> realNode = new TreeMap();
    private String[] nodes;
    //每个真实节点对应的虚拟节点数
    private int replicCnt;

    public ConsistentHashLoadBalance(String[] nodes) {
        //引用类型不能直接传递赋值
        this.nodes = Arrays.copyOf(nodes, nodes.length);
        initalization();
    }

    /**
     * 初始化哈希环
     * 循环计算每个node名称的哈希值，将其放入treeMap集合中
     */
    private void initalization() {
        for (String nodeName : nodes) {
            //一个Hash值对应一个名称
            realNode.put(hash(nodeName, 0), nodeName);
        }
    }

    /**
     * 根据资源key选择返回响应的节点名称(哪台redis服务器)
     *
     * @param key
     * @return
     */
    public String selectNode(String key) {
        Long hashOfKey = hash(key, 0);
        if (!realNode.containsKey(hashOfKey)) {
            //ceilingEntry()的作用是得到比hashOfKey大的第一个Entry
            Map.Entry<Long, String> entry = realNode.ceilingEntry(hashOfKey);
            if (entry != null) {
                return entry.getValue();
            } else {
                return nodes[0];
            }
        } else {
            return realNode.get(hashOfKey);
        }
    }

    /**
     *
     */
    private void printTreeNode() {
        if (realNode != null && realNode.size() > 0) {
            realNode.forEach((hashKey, node) -> {
                System.out.println(new StringBuffer(node).append("---->").append(hashKey));
            });
        }
    }

    public static void main(String[] args) {
        String[] nodes = new String[]{"192.168.2.1:8080", "192.168.2.2:8080", "192.168.2.3:8080", "192.168.2.4:8080"};
        ConsistentHashLoadBalance consistentHashLoadBalance = new ConsistentHashLoadBalance(nodes);
        consistentHashLoadBalance.printTreeNode();
        System.out.println(consistentHashLoadBalance.selectNode("key"));

        //从执行结果可以看到，hash值分布的距离比较开阔。


    }

    /**
     * Hash算法
     *
     * @param nodeName
     * @param number
     * @return
     */
    private Long hash(String nodeName, int number) {
        byte[] digest = md5(nodeName);
        return (((long) (digest[3 + number * 4] & 0xFF) << 24)
                | ((long) (digest[2 + number * 4] & 0xFF) << 16)
                | ((long) (digest[1 + number * 4] & 0xFF) << 8)
                | (digest[number * 4] & 0xFF))
                & 0xFFFFFFFFL;
    }


    /**
     * MD5摘要算法
     *
     * @param str
     * @return
     */
    public byte[] md5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(str.getBytes("UTF-8"));
            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }


}
