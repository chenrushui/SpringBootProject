package com.demo.www.springbootdemo.module.mongdb.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Created on 2019/10/21 9:54
 * author:crs
 * Description:XXX
 */
@Component
public class MongDBDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void saveData(MongDBEntity mongDBEntity) {
        mongoTemplate.save(mongDBEntity);
    }

    /**
     * 根据属性查询文档
     * @param name
     * @return
     */
    public MongDBEntity findEntityByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        MongDBEntity entity = mongoTemplate.findOne(query, MongDBEntity.class);
        return entity;
    }

    /**
     * 查询对象Query，更新对象
     * @param mongDBEntity
     */
    public void updateData(MongDBEntity mongDBEntity) {
        Query query = new Query(Criteria.where("id").is(mongDBEntity.getId()));
        Update update= new Update().set("age", mongDBEntity.getAge()).set("name", mongDBEntity.getName());
        mongoTemplate.updateFirst(query,update,MongDBEntity.class);
    }

    public void deleteById(int i) {
        Query query = new Query(Criteria.where("id").is(i));
        mongoTemplate.remove(query,MongDBEntity.class);
    }

    /**
     * 通过id查询mongodb中的数据
     * @param id
     * @return
     */
    public MongDBEntity getDataById(Integer id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query,MongDBEntity.class);
    }


    /**
     * 查询指定集合中所有的文档
     * @return
     */
    public List<MongDBEntity> findEntitys() {
        return mongoTemplate.findAll(MongDBEntity.class);
    }
}
