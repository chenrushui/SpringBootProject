package com.demo.www.springbootdemo.module.hash;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019/11/27 10:54
 * author:crs
 * Description:CacheManage
 */
public class CacheManage {

    private Logger log= LoggerFactory.getLogger(this.getClass());

    private List<CacheNode> cacheNodeList;
    private Long MAX_CIRCLE = (1L << 32) - 1;

    private Long hash(String nodeName) {
        System.out.println(MAX_CIRCLE);
        return MAX_CIRCLE & nodeName.hashCode();
    }


    /**
     * 获取某个结点下所有的下标
     *
     * @param hash
     * @return
     */
    public int getNodeIndex(Long hash) {
        //把某个参数的hash值传递进去（0,1,2）
        int index = cacheNodeList.size();
        for (int i = 0; i < index; i++) {
            if (hash <= hash(cacheNodeList.get(i).getCacheName())) {
                index=i;
                break;
            }
        }
        return index;
    }

    private void printList(){
        for (CacheNode node: cacheNodeList) {
            System.out.println(node.toString());
        }
    }




    /**
     * 初始化带有虚拟节点的节点链表
     * @param size
     * @param virtualSize
     */
    public void initValueNode(int size,int virtualSize){
        cacheNodeList = new ArrayList<>();
        System.out.println(MAX_CIRCLE);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <virtualSize ; j++) {
                CacheNode node = new CacheNode();
                node.setCacheName("" + i + "_" + j + i + j + "_node_" + i + "_" + j);
                node.setCacheIP("192.168.1.10" + i);
                //通过主机名获取hash值
                Long hashValue = hash(node.getCacheName());
                node.setHashValue(hashValue);

                int index = getNodeIndex(hashValue);
                if (index==cacheNodeList.size()){
                    cacheNodeList.add(node);
                }else{
                    cacheNodeList.add(index, node);
                }
            }
        }
        printList();
    }

    /**
     * 初始化节点列表
     * @param size
     */
    public void initCacheNode(int size) {
        cacheNodeList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            CacheNode cacheNode = new CacheNode();
            cacheNode.setCacheName("node_" + i);
            cacheNode.setCacheIP("192.168.1.10" + i);
            Long hashValue = hash(cacheNode.getCacheName());
            cacheNode.setHashValue(hashValue);
            int index = getNodeIndex(hashValue);
            if (index == 0) {
                cacheNodeList.add(cacheNode);
            } else {
                cacheNodeList.add(index, cacheNode);
            }

            //printList();
        }

        printList();
    }


    /**
     * 存数据
     * @param data
     */
    public void putData(String data) {
        Long hashValue = hash(data);
        int index = getNodeIndex(hashValue);
        log.info("数据存储在哪个reids节点上，下标"+index);
        if(index == cacheNodeList.size()){
            index = 0;
        }
        log.info("data:{}[{}] put into ====>{}", data, hashValue, cacheNodeList.get(index));
    }


}
