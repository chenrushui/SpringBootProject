package com.demo.www.springbootdemo.crs.jpa;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserDORepository extends PagingAndSortingRepository<UserDO,Long>, JpaSpecificationExecutor<UserDO> {

    //查询所有
    @Query(value = "select * from auth_use",nativeQuery = true)
    List<UserDO> getAllData();

    //更新信息
    @Transactional
    @Modifying
    @Query(value = "update auth_use a set a.name=:#{#userDO.name} where a.id=:#{#userDO.id}",nativeQuery = true)
    void updateDataById(@Param("userDO") UserDO userDO);
}
