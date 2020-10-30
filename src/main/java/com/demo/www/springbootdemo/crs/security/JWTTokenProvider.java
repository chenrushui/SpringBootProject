package com.demo.www.springbootdemo.crs.security;

import org.springframework.stereotype.Component;

/**
 * jwt token生成器
 */
@Component
public class JWTTokenProvider {

    public String getGeneralToken( JWTUserDetails jwtUserDetails){
        return "";
    }

}
