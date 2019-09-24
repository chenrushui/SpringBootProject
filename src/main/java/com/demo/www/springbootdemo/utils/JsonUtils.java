package com.demo.www.springbootdemo.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * Created on 2019/3/28.
 * author:crs
 * Description:Json对象序列化工具(对象和字符串之间的转化)
 */
public class JsonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 把对象转化成String
     *
     * @param object
     * @param <T>
     * @return
     */
    public static <T> String objToString(T object) {
        if (object == null) {
            return null;
        }
        try {
            if (object instanceof String) {
                return (String) object;
            } else {
                return objectMapper.writeValueAsString(object);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 把String转化成Object
     *
     * @param str
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T stringToObject(String str, Class<T> clazz) {
        if (StringUtils.isEmpty(str) || clazz == null) {
            return null;
        }
        try {
            if (clazz.equals(String.class)) {
                return (T) str;
            } else {
                return objectMapper.readValue(str, clazz);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
