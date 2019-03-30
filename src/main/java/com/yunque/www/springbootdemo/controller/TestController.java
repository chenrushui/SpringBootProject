package com.yunque.www.springbootdemo.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

@Controller
@RequestMapping(value = "/test")
public class TestController {

    /**
     * 通过value注解获取配置文件中的值，项目开发中经常用
     */
    @Value("${person.lastName}")
    private String name;

    @ApiIgnore
    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello() {
        return "hello world";
    }

    @ApiIgnore
    @RequestMapping(value = "/name")
    @ResponseBody
    public String helloName() {
        return "hello" + name;
    }

    @ApiOperation(value = "获取请求结果" )
    @GetMapping(value = "/success")
    public String success(Map<String, String> map) {
        map.put("hello", "你好,陈如水");
        return "success";
    }
}
