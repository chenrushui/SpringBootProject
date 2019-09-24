package com.demo.www.springbootdemo.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created on 2019/3/24.
 * author:crs
 * Description:医生分类
 */
@Data
public class Title implements Serializable {
    private Integer id;

    private Integer titleId;

    private String name;

    private Integer seqNo;

    private Integer parentId;

    private Integer deleteFlag;

    private Integer creatId;

    private Date creatTime;

    private Integer modifyId;

    private Date modifyTime;

}
