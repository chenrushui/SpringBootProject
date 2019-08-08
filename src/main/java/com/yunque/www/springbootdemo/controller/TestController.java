package com.yunque.www.springbootdemo.controller;

import com.yunque.www.springbootdemo.pojo.BaseResult;
import com.yunque.www.springbootdemo.pojo.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
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


    @ApiOperation(value = "获取请求结果")
    @GetMapping(value = "/success")
    public String success(Map<String, String> map) {
        map.put("hello", "你好,陈如水");
        return "success";
    }

    //HttpServletRequest类的使用
    @ResponseBody
    @PostMapping(value = "/add/user", produces = "application/json;charset=utf-8")
    public BaseResult addUser(@RequestBody User use) {
//        String name = request.getParameter("name");
//        String password = request.getParameter("password");
//        User user = new User(name, password);
//        user.setName(name);
//        user.setPassword(password);
        BaseResult baseResult = new BaseResult();
        baseResult.setData(use);
        baseResult.setCode(200);
        baseResult.setMessage("请求成功！");
        return baseResult;
    }
}
