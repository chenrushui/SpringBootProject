//package com.demo.www.springbootdemo.module.mongdb;
//
//import com.demo.www.springbootdemo.module.mongdb.demo.MongDBEntity;
//import com.mongodb.*;
//import com.mongodb.client.FindIterable;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//import org.bson.Document;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.UUID;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
///**
// * Created on 2019/10/17 19:30
// * author:crs
// * Description:使用java代码操作mongdb
// */
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class MongDBTest {
//
//
//
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//
//
////    //初始化mongdb
////    @Before
////    public void before() {
////        MongoCredential credential = MongoCredential.createCredential("pica_user", "picadb", "2wsx3edc".toCharArray());
////        mongoClient = new MongoClient(new ServerAddress("192.168.140.30", 27071), Arrays.asList(credential));
////    }
//
//    @Test
//    public void testCURD() {
////        MongoDatabase picadb = mongoTemplate.getDb();
////        MongoCollection<Document> document = picadb.getCollection("bi_doctor_activation_info");
////        FindIterable<Document> documents = document.find();
////        for (Document d : documents) {
////            System.out.println(d.toJson());
////        }
//
//    }
//    @Test
//    public  void  testGroups_org() {
//        List<EcosSytemEntity> groups_org = mongoTemplate.findAll(EcosSytemEntity.class, "groups_org");
//        for (EcosSytemEntity entity : groups_org) {
//            System.out.println(entity.getHierarchy());
//        }
//        System.out.println(groups_org.size());
//        System.out.println("----------------------");
//
//
//        String str = "(14001,388207,391332,(391341,391387)391816,(393388,397577)406228,407656,408042,408909,411682,411793,411931,418996,419248,419275,419679,419746,420289,420564,420628,420638,420647,421115,421428,423598,427216,430003,430042,435653,54457,54458,54459,54460,(54462,54463,54464,54470,98629,103635,103638)54461)419771";
//
//        String regex = "\\(([^}])*\\)";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(str);
//        while (matcher.find()) {
//            System.out.println(matcher.group());
//        }
//
//
//
//        int IndexOf = str.indexOf("(");
//        int lastIndexOf = str.lastIndexOf(")");
//
//
//
//    }
//}
