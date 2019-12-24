package com.demo.www.springbootdemo.module.redisclient1.command;

import java.util.Map;

/**
 * Created on 2019/12/23 17:33
 * author:crs
 * Description:ICacheTokenCommands
 */
public interface ICacheTokenCommands {
    String saveToken(Map<String, String> var1, int var2) throws Exception;

    Map<String, String> getToken(String var1);

    <T> T getToken(String var1, Class<T> var2);

    String getTokenByUserId(String var1, String var2);

    Boolean deleteToken(String var1);
}
