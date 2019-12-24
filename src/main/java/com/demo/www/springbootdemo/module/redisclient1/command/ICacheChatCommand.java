package com.demo.www.springbootdemo.module.redisclient1.command;

import java.util.List;
import java.util.Map;

/**
 * Created on 2019/12/23 17:07
 * author:crs
 * Description:聊天数据存储
 */
public interface ICacheChatCommand {
    void saveMsg(Integer var1, Integer var2, String var3, Long var4);

    void saveMeAtMsg(Integer var1, Integer var2, Integer var3, String var4, Long var5);

    List<Map.Entry<String, String>> getExclusiveMsg(Integer var1, Integer var2);

    List<String> getMsgs(Integer var1, Integer var2, Integer var3);

    Long getMsgCount(Integer var1);

    void saveQuestion(Integer var1, Integer var2, String var3, Long var4);

    List<Map.Entry<String, String>> getQuestions(Integer var1);

}
