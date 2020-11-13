package com.demo.www.springbootdemo.crs.redis.lru;

/**
 * 定义node节点
 */
public class Node<K,V> {
    //键
    K key;
    //值
    V value;
    //上一个节点
    Node pre;
    //下一个节点
    Node next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
