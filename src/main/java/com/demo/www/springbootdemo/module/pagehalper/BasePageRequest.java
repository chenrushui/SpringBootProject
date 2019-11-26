package com.demo.www.springbootdemo.module.pagehalper;

/**
 * Created on 2019/10/15 16:57
 * author:crs
 * Description:分页查询
 */
public class BasePageRequest {
    //页码数，默认查询第一页
    private int pageNum;
    //每页记录数，默认每页查询十条记录
    private int pageSize;

    public int getPageNum() {
        if (pageNum <= 0) {
            pageNum = 1;
        }
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        if (pageSize <= 0) {
            pageSize = 10;
        }
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}
