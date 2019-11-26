package com.demo.www.springbootdemo.module.mongdb.demo;


import com.demo.www.springbootdemo.pojo.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on 2019/10/21 9:52
 * author:crs
 * Description:通过代码操作mongoDB
 */
@RestController
@RequestMapping(value = "/mongo")
public class MongoDBController {

//    @Autowired
//    private MongDBDao mongDBDao;
//
//    @GetMapping(value = "/post")
//    public BaseResult saveData(@RequestParam("id") Integer id){
//        MongDBEntity mongDBEntity = new MongDBEntity();
//        mongDBEntity.setId(id);
//        mongDBEntity.setAge(23);
//        mongDBEntity.setName("crs");
//        mongDBDao.saveData(mongDBEntity);
//        MongDBEntity entity=  mongDBDao.getDataById(id);
//        return   BaseResult.toResponse(entity);
//    }
//
//    @GetMapping(value = "/get")
//    public MongDBEntity getData(){
//        MongDBEntity entity= mongDBDao.findEntityByName("crs");
//        System.out.println("打印获取的信息"+entity.toString());
//        return entity;
//    }
//
//    @GetMapping(value = "/get/list")
//    public List<MongDBEntity> getListData(){
//        List<MongDBEntity> list= mongDBDao.findEntitys();
//        return list;
//    }
//
//
//    @GetMapping(value = "/update")
//    public PicaResponse updateData(){
//        MongDBEntity mongDBEntity = new MongDBEntity();
//        mongDBEntity.setId(11);
//        mongDBEntity.setAge(44);
//        mongDBEntity.setName("crs44");
//        mongDBDao.updateData(mongDBEntity);
//      return  PicaResponse.toResponse();
//    }
//
//    @GetMapping(value = "/delete")
//    public PicaResponse  deleteById(){
//        mongDBDao.deleteById(11);
//        return PicaResponse.toResponse();
//    }









}
