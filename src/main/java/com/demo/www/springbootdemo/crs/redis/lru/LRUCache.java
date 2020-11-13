package com.demo.www.springbootdemo.crs.redis.lru;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LRUCache<K,V> {
    //容量
    private int capacity;
    //当前有多少节点的统计
    private int count;

    //通过map集合缓存节点(真正缓存数据的集合)
    private Map<K, Node<K, V>> nodeMap;
    //头节点
    private Node<K,V> head;
    //尾节点
    private Node<K,V> tail;

    //创建一个指定大小的缓存集合
    public LRUCache(int capacity){
        if (capacity<1){
            throw new IllegalArgumentException(String.valueOf(capacity));
        }
        this.capacity = capacity;
        this.nodeMap = new HashMap<>();
        //初始化头节点和尾节点，利用哨兵模式减少判断头结点和尾节点为空的代码
        Node headNode = new Node(null, null);
        Node tailNode = new Node(null, null);
        headNode.next = tailNode;
        tailNode.pre = headNode;
        this.head = headNode;
        this.tail = tailNode;
    }

    /**
     * 存储数据
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        Node<K,V> node = nodeMap.get(key);
        if (node == null) {
            if (count >= capacity) {
                //先移除一个节点
                removeNode();
            }
            node = new Node<>(key, value);
            //添加节点
            addNode(node);
        } else {
            //移动节点到头节点
            moveNodeToHead(node);
        }
    }

    private void removeNode() {
        Node node = tail.pre;
        //从链表里面移除
        removeFromList(node);
        nodeMap.remove(node.key);
        count--;
    }

    private void removeFromList(Node<K,V> node) {
        Node pre = node.pre;
        Node next = node.next;

        pre.next = next;
        next.pre = pre;

        node.next = null;
        node.pre = null;
    }

    private void addNode(Node<K,V> node) {
        //添加节点到头部
        addToHead(node);
        nodeMap.put(node.key, node);
        count++;
    }

    private void addToHead(Node<K,V> node) {
        Node next = head.next;
        next.pre = node;
        node.next = next;
        node.pre = head;
        head.next = node;
    }

    public void moveNodeToHead(Node<K,V> node) {
        //从链表里面移除
        removeFromList(node);
        //添加节点到头部
        addToHead(node);


        ArrayList<Object> objects = new ArrayList<>();
        objects.forEach((item)->{
            System.out.println(item);
        });
    }








}
