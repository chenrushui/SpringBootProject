package com.demo.www.springbootdemo.module.hash;

/**
 * Created on 2019/11/27 10:53
 * author:crs
 * Description:CacheNode缓存结点
 */
public class CacheNode {

    private String cacheName;
    private String cacheIP;
    private Long hashValue;

    public CacheNode() {
    }

    public CacheNode(String cacheName, String cacheIP, Long hashValue) {
        this.cacheName = cacheName;
        this.cacheIP = cacheIP;
        this.hashValue = hashValue;
    }

    public String getCacheName() {
        return cacheName;
    }

    public void setCacheName(String cacheName) {
        this.cacheName = cacheName;
    }

    public String getCacheIP() {
        return cacheIP;
    }

    public void setCacheIP(String cacheIP) {
        this.cacheIP = cacheIP;
    }

    public Long getHashValue() {
        return hashValue;
    }

    public void setHashValue(Long hashValue) {
        this.hashValue = hashValue;
    }

    @Override
    public String toString() {
        return "CacheNode{" +
                "cacheName='" + cacheName + '\'' +
                ", cacheIP='" + cacheIP + '\'' +
                ", hashValue=" + hashValue +
                '}';
    }
}


