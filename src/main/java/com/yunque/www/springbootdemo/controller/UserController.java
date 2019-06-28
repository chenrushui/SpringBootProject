package com.yunque.www.springbootdemo.controller;

import com.yunque.www.springbootdemo.pojo.BaseResult;
import com.yunque.www.springbootdemo.pojo.User;
import com.yunque.www.springbootdemo.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

@Api(value = "/user", description = "用户类API")
@RestController
public class UserController {

    @Autowired
    IUserService iUserService;


    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @ApiOperation(value = "用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")
    })
    //localhost:8082/add/user?name=crs&password=1231
    @GetMapping(value = "/add/user", produces = "application/json;charset=utf-8")
    public BaseResult addUser(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        BaseResult baseResult = new BaseResult();
        baseResult.setResult(user);
        baseResult.setCode(200);
        baseResult.setMessage("请求成功！");
        return baseResult;
    }


    @ApiOperation(value = "添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")
    })
    //HttpServletRequest类的使用
    @PostMapping(value = "/add/user", produces = "application/json;charset=utf-8")
    public BaseResult addUser(HttpServletRequest request) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        BaseResult baseResult = new BaseResult();
        baseResult.setResult(user);
        baseResult.setCode(200);
        baseResult.setMessage("请求成功！");
        return baseResult;
    }

    @ApiIgnore
    //通过Bean接收数据？
    //HttpServletRequest类的使用
    @PostMapping(value = "/adduse", produces = "application/json;charset=utf-8")
    public BaseResult addUser(User user) {
        BaseResult baseResult = new BaseResult();
        baseResult.setResult(user);
        baseResult.setCode(200);
        baseResult.setMessage("请求成功");
        return baseResult;
    }

    @ApiIgnore
    //路径映射
    @GetMapping(value = "/adduse/{name}", produces = "application/json;charset=utf-8")
    public BaseResult addUserPath(@PathVariable("name") String name) {
        BaseResult baseResult = new BaseResult();
        baseResult.setResult(name);
        baseResult.setCode(200);
        baseResult.setMessage("请求成功！");
        return baseResult;
    }

    //http://localhost:9000/add/test
    @ApiIgnore
    //todo：如何去掉空的null？使用注解解决
    //@RequestParam
    @GetMapping(value = "/add/test", produces = "application/json;charset=utf-8")
    public BaseResult addUserPat(@RequestParam(value = "NAME", required = false) String name, String password) {
        BaseResult baseResult = new BaseResult();
        User user = new User();
        if (!StringUtils.isEmpty(name)) {
            user.setName(name);
        }
        user.setPassword(password);
        baseResult.setResult(user);
        baseResult.setCode(200);
        baseResult.setMessage("请求成功");
        logger.info(baseResult.toString());
        return baseResult;
    }

    @PostMapping(value = "/post")
    public BaseResult addUserPost(@RequestBody User user) {
        return new BaseResult();
    }

    //http://localhost:9000/user/get
    @GetMapping(value = "/user/get")
    public BaseResult getUserInfo() {
        User user = new User();
        User u = iUserService.printUser(user);
        BaseResult baseResult = new BaseResult();
        baseResult.setResult(u.getName());
        return baseResult;
    }

}
