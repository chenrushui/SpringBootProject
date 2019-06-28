package com.yunque.www.springbootdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 2019/3/28.
 * author:crs
 * Description:RedisEntity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisEntity {
    private String name;
    private String value;
}
