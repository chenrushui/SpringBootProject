// Copyright 2016-2101 Pica.
package com.demo.www.springbootdemo.module.pagehalper;

import java.util.List;

public class BasePageResult<T> {
    //当前页码
    private Integer pageNum;
    //每页查询数量
    private Integer pageSize;
    //总的记录数
    private Long total;
    //查询到的数据
    private List<T> list;

    public BasePageResult() {
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}

