package com.yunque.www.springbootdemo.module.anno.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@MyFirstAnnotation(name = "crs", age = 20)
public class MyController {

    @Autowired
    private TestEntity testEntity;

    @GetMapping("/custom/anno")
    public String sayHello() {
        return testEntity.toString();
    }
}
