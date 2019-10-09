package com.demo.www.springbootdemo.module.moredatesource;

import com.alibaba.fastjson.JSONObject;
import com.demo.www.springbootdemo.mapper.DataSourceMapper;
import com.demo.www.springbootdemo.pojo.DataSourceEntity;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2019/9/19 15:32
 * author:crs
 * Description:多数据源Controller
 */
@Api(description = "多数据源资源接口")
@RestController
@RequestMapping(value = "/data")
public class DataSourceController {

    @Autowired
    private DataSourceMapper dataSourceMapper;

    //http://localhost:8080/data/dev?id=9
    @GetMapping(value = "/dev", produces = "application/json;charset=utf8")
    public String getDevData(Integer id) {
//        DynamicDataSource.setDataSourcesType(DataSourceType.DEV);
        DataSourceEntity entity = dataSourceMapper.getDoctorInfoById(id);
        return JSONObject.toJSONString(entity);
    }

    //http://localhost:8080/data/test?name=Krystal
    @GetMapping(value = "/test", produces = "application/json;charset=utf8")
    public String getDevData(String name) {
//        DynamicDataSource.setDataSourcesType(DataSourceType.TEST);
        DataSourceEntity entity = dataSourceMapper.getDoctorInfoByName(name);
        return JSONObject.toJSONString(entity);
    }
}
