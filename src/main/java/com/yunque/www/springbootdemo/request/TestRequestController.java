package com.yunque.www.springbootdemo.request;

import com.yunque.www.springbootdemo.pojo.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/request")
public class TestRequestController {

    @Autowired
    private RequestUtils requestUtils;

    @GetMapping(value = "/header")
    public BaseResult<String> getHeadInfo() {
        //从请求头中取出信息并返回，已经测试成功，可以获取到请求头中的信息
        String tokenFromHead = requestUtils.getTokenFromHead();
        return BaseResult.buildSuccess(tokenFromHead);
    }

}
