package com.demo.www.springbootdemo.module.redisclient1.command;

import java.util.List;

/**
 * Created on 2019/12/23 17:37
 * author:crs
 * Description:ICacheExtensionCommands
 */
public interface ICacheExtensionCommands {
    <T> T get(String var1, Class<T> var2);

    <T> List<T> getList(String var1, Class<T> var2);

    <T> T hget(String var1, String var2, Class<T> var3);

    <T> List<T> hgetList(String var1, String var2, Class<T> var3);

    boolean hset(String var1, String var2, Object var3);

    boolean set(String var1, Object var2);

    boolean set(String var1, Object var2, int var3);
}
