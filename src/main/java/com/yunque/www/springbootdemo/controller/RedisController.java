//package com.yunque.www.springbootdemo.controller;
//
//import com.yunque.www.springbootdemo.pojo.BaseResult;
//import com.yunque.www.springbootdemo.pojo.RedisEntity;
//import com.yunque.www.springbootdemo.utils.JsonUtils;
//import com.yunque.www.springbootdemo.utils.RedisClient;
//import com.yunque.www.springbootdemo.utils.RedisUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
///**
// * Created on 2019/3/28.
// * author:crs
// * Description:测试Redis的使用
// */
//@Controller
//@RequestMapping(value = "/redis")
//public class RedisController {
//
//    @Autowired
//    private RedisClient redisClient;
//
//    @Autowired
//    private RedisUtil redisUtil;
//
//    @ResponseBody
//    @RequestMapping("/expire")
//    public BaseResult setExpireTime() {
//        boolean isSuccess = redisUtil.set("productData", "product", 0);
//        redisUtil.expire("productData", 100);
//        return BaseResult.buildSuccess(isSuccess);
//    }
//
//    @ResponseBody
//    @PostMapping(value = "/add", produces = "application/json;charset=utf-8")
//    public BaseResult addRedisData(@RequestBody RedisEntity entity) {
//        boolean isSuccess = redisUtil.set(entity.getName(), entity.getValue(), 0);
//        redisUtil.expire(entity.getName(), 100);
//        return BaseResult.buildSuccess(isSuccess);
//    }
//
//    @ResponseBody
//    @GetMapping(value = "/get", produces = "application/json;charset=utf-8")
//    public BaseResult getRedisData(@RequestParam(value = "name") String name) {
//
//        String value = null;
//        if (redisUtil.hasKey("name")) {
//            value = redisClient.get(name);
//        }
//        return BaseResult.buildSuccess(value);
//    }
//
//    /**
//     * 存储对象
//     *
//     * @return
//     */
//    @ResponseBody
//    @PostMapping(value = "/add/entity", produces = "application/json;charset=utf-8")
//    public BaseResult addRedisEntity() {
//        RedisEntity redisEntity = new RedisEntity("entityName", "entityValue");
//        String str = JsonUtils.objToString(redisEntity);
//        boolean isSuccess = redisClient.set("use", str);
//        return BaseResult.buildSuccess(isSuccess);
//    }
//
//    /**
//     * 获取存储的对象
//     *
//     * @param use
//     * @return
//     */
//    @ResponseBody
//    @GetMapping(value = "/get/entity", produces = "application/json;charset=utf-8")
//    public BaseResult getRedisEntity(@RequestParam(value = "use") String use) {
//        String str = redisClient.get(use);
//        RedisEntity redisEntity = JsonUtils.stringToObject(str, RedisEntity.class);
//        //todo:通过实例对象访问类的静态成员，没必要；直接类名点方法名即可
//        //todo:把请求成功和请求失败的逻辑封装到BaseResult里面直接使用。
//        //return new BaseResult().buildSuccess(redisEntity);
//        return BaseResult.buildSuccess(redisEntity);
//
//    }
//
//
//}
