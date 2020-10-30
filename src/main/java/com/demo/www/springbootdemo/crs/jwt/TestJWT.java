package com.demo.www.springbootdemo.crs.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestJWT {
    public static void main(String[] args) {
        //1，需要引入jwt的依赖；
        //2，传入用户id；
        //3，设置过期时间；
        //用户id：04e0f160-b651-474a-810e-e517b5824290。

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 86400000);
        Map map=new HashMap<String,String>();

        //传入用户id，传入盐值
        String compact = Jwts.builder()
                .setClaims(map)     //数据存储部分。
                .setSubject("04e0f160-b651-474a-810e-e517b5824290")   //密钥主题
                .setIssuedAt(new Date())     //签发时间
                .setExpiration(expiryDate)   //过期时间
                .signWith(SignatureAlgorithm.HS512, "123456QWEasd") //签名算法以及密匙
                .compact();
        System.out.println(compact);

    }
}
