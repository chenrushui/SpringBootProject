package com.yunque.www.springbootdemo.pojo;

/**
 * 加解密数据模型
 */
public class EncryptEntity {

    /**
     * 加密后的密文
     */
    private String key;
    /**
     * 加密后的数据
     */
    private String content;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "EncryptEntity{" +
                "key='" + key + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
