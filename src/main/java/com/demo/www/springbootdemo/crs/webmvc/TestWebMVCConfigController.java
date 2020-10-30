package com.demo.www.springbootdemo.crs.webmvc;

import com.demo.www.springbootdemo.pojo.BaseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/mvc")
@RestController
public class TestWebMVCConfigController {

    @GetMapping("/interceptor")
    public BaseResult testInterceptor() {
        System.out.println("testInterceptor");
        return BaseResult.buildSuccess();
    }
}
