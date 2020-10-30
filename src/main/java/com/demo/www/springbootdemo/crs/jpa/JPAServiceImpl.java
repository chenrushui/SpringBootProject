package com.demo.www.springbootdemo.crs.jpa;

import com.sun.xml.internal.fastinfoset.util.ValueArrayResourceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class JPAServiceImpl implements JPAService {

    @Autowired
    private UserDORepository userDORepository;

    @Override
    public Long save(UserDO userDO) {
        userDORepository.save(userDO);
        return userDO.getId();
    }

    @Override
    public List<UserDO> getDataByJPA() {
        //return userDORepository.getAllData();
        return userDORepository.getAllData();
    }

    @Override
    public UserDO getDataById(Long id) {
        return userDORepository.findById(id).get();
    }

    @Override
    public void updateDataById(UserDO userDO) {
        userDORepository.updateDataById(userDO);
    }

    @Override
    public BasePageResponse<UserDO> getDataByIds(UserDORequest request) {
        Specification<UserDO> userDOSpecification = new Specification<UserDO>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path path = root.get("id");
                return criteriaBuilder.gt(path,request.getId());
            }
        };
        Sort.Order order = new Sort.Order(Sort.Direction.ASC,"id");
        Sort sort = new Sort(order);
        //直接返回page不太好，很多不需要的字段在里面。
        PageRequest pageRequest = new PageRequest(request.getPageNum()-1,request.getPageSize(),sort);
        Page<UserDO> page = userDORepository.findAll(userDOSpecification,pageRequest);
        BasePageResponse<UserDO> basePageResponse = new BasePageResponse<>();
        basePageResponse.setList(page.getContent());
        basePageResponse.setTotal(page.getTotalElements());
        basePageResponse.setPageNum(request.getPageNum());
        basePageResponse.setPageSize(request.getPageSize());
        log.info("总页数"+page.getTotalPages());
        log.info("总记录数"+page.getTotalElements());
        log.info("当前页面的数据集合"+page.getContent());
        log.info("当前页面的记录数"+page.getNumberOfElements());
        return basePageResponse;
    }
}
