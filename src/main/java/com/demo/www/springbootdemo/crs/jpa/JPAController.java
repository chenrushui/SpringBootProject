package com.demo.www.springbootdemo.crs.jpa;


import com.demo.www.springbootdemo.pojo.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("/jpa")
public class JPAController {

    @Autowired
    private JPAService jpaService;

    //{"name":"crs11111","account":"13024112588","pwd":"qq123456"}
    @ApiOperation("用户信息接口")
    @PostMapping("/save")
    public BaseResult saveDataByJPA(@RequestBody UserDO userDO) {
        Long id = jpaService.save(userDO);
        return BaseResult.buildSuccess(id);
    }

    @GetMapping("/get")
    public BaseResult getDataByJPA() {
        List<UserDO> list=jpaService.getDataByJPA();
        return BaseResult.buildSuccess(list);
    }

    //{"name":"crs11111","account":"13024112588","pwd":"qq123456"}
    @ApiOperation("分页查询数据")
    @PostMapping("/getDataByIds")
    public BaseResult<List<UserDO>> getDataByIds(@RequestBody UserDORequest request) {
        BasePageResponse<UserDO> basePageResponse =jpaService.getDataByIds(request);
        return BaseResult.buildSuccess(basePageResponse);
    }

    @GetMapping("/get/{id}")
    public BaseResult getDataById(@PathVariable  Long id) {
        UserDO userDO =jpaService.getDataById(id);
        return BaseResult.buildSuccess(userDO);
    }

    @PostMapping("/modify")
    public BaseResult updateDataById(@RequestBody UserDO userDO) {
        jpaService.updateDataById(userDO);
        return BaseResult.buildSuccess();
    }
}
