package com.demo.www.springbootdemo.crs.jpa;

import org.springframework.data.domain.Page;

import java.util.List;

public interface JPAService {

    Long save(UserDO userDO);

    List<UserDO> getDataByJPA();

    UserDO getDataById(Long id);

    void updateDataById(UserDO userDO);

    BasePageResponse<UserDO> getDataByIds(UserDORequest request);
}
