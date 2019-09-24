package com.demo.www.springbootdemo.module;

public class LikeEntity {
    //用户id
    private Integer userId;
    //文章id
    private Integer articalId;

    public LikeEntity(Integer userId, Integer articalId) {
        this.userId = userId;
        this.articalId = articalId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getArticalId() {
        return articalId;
    }

    public void setArticalId(Integer articalId) {
        this.articalId = articalId;
    }
}
