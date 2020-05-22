package com.demo.www.springbootdemo.module.order;

/**
 * Created on 2020/4/23 15:43
 * author:crs
 * Description:token令牌
 */
public interface TokenService {
    String getToken();

    Boolean checkToken(String token);

}
