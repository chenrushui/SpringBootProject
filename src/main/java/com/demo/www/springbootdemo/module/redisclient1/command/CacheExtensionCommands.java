package com.demo.www.springbootdemo.module.redisclient1.command;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created on 2019/12/23 17:37
 * author:crs
 * Description:CacheExtensionCommands
 */
public class CacheExtensionCommands implements ICacheExtensionCommands {
    private static final Logger logger = Logger.getLogger("CacheExtensionCommands");
    private final ObjectMapper mapper = new ObjectMapper();
    private ICacheCoreCommands command;
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public CacheExtensionCommands(ICacheCoreCommands command, String keyPrefix) {
        this.command = command;
        //this.keyPrefix = keyPrefix;
        this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.mapper.setDateFormat(this.simpleDateFormat);
    }

    public <T> T get(String key, Class<T> klass) {
        try {
            return this.mapper.readValue(this.command.get(key), klass);
        } catch (Exception var4) {
            logger.log(Level.SEVERE, var4.getMessage(), var4);
            return null;
        }
    }

    public <T> List<T> getList(String key, Class<T> klass) {
        try {
            JavaType javaType = this.mapper.getTypeFactory().constructParametricType(ArrayList.class, new Class[]{klass});
            String value = this.command.get(key);
            return (List)(value != null && !"".equals(value) ? (List)this.mapper.readValue(this.command.get(key), javaType) : new ArrayList());
        } catch (Exception var5) {
            logger.log(Level.SEVERE, var5.getMessage(), var5);
            return new ArrayList();
        }
    }

    public <T> T hget(String key, String field, Class<T> clazz) {
        try {
            return this.mapper.readValue(this.command.hget(key, field), clazz);
        } catch (Exception var5) {
            logger.log(Level.SEVERE, var5.getMessage(), var5);
            return null;
        }
    }

    public <T> List<T> hgetList(String key, String field, Class<T> klass) {
        try {
            JavaType javaType = this.mapper.getTypeFactory().constructParametricType(ArrayList.class, new Class[]{klass});
            return (List)this.mapper.readValue(this.command.hget(key, field), javaType);
        } catch (Exception var5) {
            logger.log(Level.SEVERE, var5.getMessage(), var5);
            return null;
        }
    }

    public boolean hset(String key, String field, Object value) {
        try {
            this.command.hset(key, field, this.mapper.writeValueAsString(value));
            return true;
        } catch (Exception var5) {
            logger.log(Level.SEVERE, var5.getMessage(), var5);
            return false;
        }
    }

    public boolean set(String key, Object value) {
        try {
            this.command.set(key, this.mapper.writeValueAsString(value));
            return true;
        } catch (Exception var4) {
            logger.log(Level.SEVERE, var4.getMessage(), var4);
            return false;
        }
    }

    public boolean set(String key, Object value, int setExpire) {
        try {
            this.command.set(key, this.mapper.writeValueAsString(value));
            this.command.expire(key, setExpire);
            return true;
        } catch (Exception var5) {
            logger.log(Level.SEVERE, var5.getMessage(), var5);
            return false;
        }
    }
}
