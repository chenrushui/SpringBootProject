package com.demo.www.springbootdemo.module.redisclient1.command;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created on 2019/12/23 17:34
 * author:crs
 * Description:CacheTokenCommands
 */
public class CacheTokenCommands implements  ICacheTokenCommands {
    private static final String MULTI_DEVICES_LOGIN_WHITE_LIST_KEY = "MULTI_DEVICES_LOGIN_WHITE_LIST_KEY";
    private static final Logger logger = Logger.getLogger("CacheTokenCommands");
    private final ObjectMapper mapper = new ObjectMapper();
    private final ICacheCoreCommands command;
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public CacheTokenCommands(ICacheCoreCommands command) {
        this.command = command;
        this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.mapper.setDateFormat(this.simpleDateFormat);
    }

    public String saveToken(Map<String, String> hashMap, int expireSeconds) throws Exception {
        String token = "";
        if (!hashMap.containsKey("id")) {
            throw new Exception("Missing id field.");
        } else if (!hashMap.containsKey("sysCode")) {
            throw new Exception("Missing sysCode field.");
        } else {
            try {
                Integer id = Integer.parseInt((String)hashMap.get("id"));
                String sysCode = (String)hashMap.get("sysCode");
                String newToken = UUID.randomUUID().toString().replace("-", "").toUpperCase();
                String userId = this.mergeSysCode(sysCode, id) + (id > 0 ? id.toString() : newToken);
                Boolean isExpUser = this.command.hexists("MULTI_DEVICES_LOGIN_WHITE_LIST_KEY", id.toString());
                if (isExpUser && sysCode.toUpperCase().equals("SAAS")) {
                    throw new Exception("SAAS login denied due to this is experience account.");
                } else {
                    if (hashMap.containsKey("token") && ((String)hashMap.get("token")).length() > 0) {
                        newToken = (String)hashMap.get("token");
                    } else {
                        hashMap.put("token", newToken);
                    }
                    token = newToken;
                    userId = this.attachInfoToKey(userId);
                    newToken = this.attachInfoToKey(newToken);
                    Iterator var9 = hashMap.keySet().iterator();

                    String oldToken;
                    while(var9.hasNext()) {
                        oldToken = (String)var9.next();
                        this.command.hset(userId, oldToken, hashMap.get(oldToken) == null ? "" : (String)hashMap.get(oldToken));
                    }

                    String key = userId + "-" + sysCode;
                    if (!isExpUser) {
                        oldToken = this.command.get(key);
                        if (oldToken != null && oldToken.length() > 0) {
                            this.command.del(oldToken);
                        }
                    }

                    this.command.set(key, newToken);
                    this.command.set(newToken, userId);
                    if (id == 0 || isExpUser) {
                        this.command.expire(userId, expireSeconds);
                        this.command.expire(newToken, expireSeconds);
                        this.command.expire(key, expireSeconds);
                    }

                    return token;
                }
            } catch (Exception var11) {
                throw var11;
            }
        }
    }

    public Map<String, String> getToken(String token) {
        Object map = new HashMap();

        try {
            String tkn = this.attachInfoToKey(token);
            String userId = this.command.get(tkn);
            if (userId != null && userId.length() > 0) {
                map = this.command.hgetall(userId);
            }
        } catch (Exception var5) {
            ;
        }

        return (Map)map;
    }

    public <T> T getToken(String token, Class<T> klass) {
        Map<String, String> map = this.getToken(token);
        if (map != null && map.size() > 0) {
            try {
                return this.mapper.readValue(this.mapper.writeValueAsString(map), klass);
            } catch (Exception var5) {
                logger.log(Level.SEVERE, var5.getMessage(), var5);
            }
        }

        return null;
    }

    public String getTokenByUserId(String userId, String sysCode) {
        try {
            String uid = this.attachInfoToKey(this.mergeSysCode(sysCode, Integer.parseInt(userId)) + userId) + "-" + sysCode;
            return this.command.get(uid);
        } catch (Exception var4) {
            return "";
        }
    }

    public Boolean deleteToken(String token) {
        try {
            this.command.del(this.attachInfoToKey(token));
            return true;
        } catch (Exception var3) {
            return false;
        }
    }

    public String attachInfoToKey(String key) {
        if (this.validateKey(key)) {
            return "token-" + key;
        } else {
            logger.info("the key [" + key + "] doesn't match the rule");
            return null;
        }
    }

    public Boolean validateKey(String key) {
        return true;
    }

    private String mergeSysCode(String sysCode, Integer id) {
        String str = "";
        if (!sysCode.equals("saas") && !sysCode.equals("app")) {
            if (id == 0) {
                str = "guest-";
            } else {
                str = sysCode + "-";
            }
        } else {
            str = "doctor-";
        }

        return str.toLowerCase();
    }
}
