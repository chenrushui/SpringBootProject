package com.demo.www.springbootdemo.module.redisclient1.command;


import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Created on 2019/12/23 17:30
 * author:crs
 * Description:CacheChatCommand
 */
public class CacheChatCommand implements ICacheChatCommand {
    private static final Logger logger = Logger.getLogger("CacheChatCommand");
    private final ICacheCoreCommands command;

    public CacheChatCommand(ICacheCoreCommands command) {
        this.command = command;
    }

    private void saveToGlobalMsgList(Integer liveId, Integer doctorId, Integer atDoctorId, String message, Boolean isAt, Long globalIncrId) {
        String keyPrefix = "chat." + liveId + ".";
        String globalMsgKeyZSet = keyPrefix + "global.msg.key.zset";
        String globalMsgKeyHash = keyPrefix + "global.msg.key.hash";
        String messageId = (globalIncrId < 10L ? "0" + globalIncrId.toString() : globalIncrId.toString()) + "." + doctorId + (isAt ? ".at." + atDoctorId : "");

        try {
            this.command.zadd(globalMsgKeyZSet, (double)globalIncrId, messageId);
            this.command.hset(globalMsgKeyHash, messageId, message);
        } catch (Exception var12) {
            logger.log(Level.SEVERE, var12.getMessage(), var12);
        }

    }

    public void saveMsg(Integer liveId, Integer doctorId, String message, Long globalIncrId) {
        String keyPrefix = "chat." + liveId + ".";
        String exclusiveMsgId = keyPrefix + doctorId;

        try {
            this.command.hset(exclusiveMsgId, (globalIncrId < 10L ? "0" + globalIncrId.toString() : globalIncrId.toString()) + "." + doctorId, message);
            this.saveToGlobalMsgList(liveId, doctorId, 0, message, false, globalIncrId);
        } catch (Exception var8) {
            logger.log(Level.SEVERE, var8.getMessage(), var8);
        }

    }

    public void saveMeAtMsg(Integer liveId, Integer doctorId, Integer atDoctorId, String message, Long globalIncrId) {
        String keyPrefix = "chat." + liveId + ".";
        String exclusiveMsgId = keyPrefix + doctorId;
        String atExclusiveMsgId = keyPrefix + atDoctorId;

        try {
            String exclusiveMsgField = (globalIncrId < 10L ? "0" + globalIncrId.toString() : globalIncrId.toString()) + "." + doctorId + ".at." + atDoctorId;
            this.command.hset(exclusiveMsgId, exclusiveMsgField, message);
            this.command.hset(atExclusiveMsgId, exclusiveMsgField, message);
            this.saveToGlobalMsgList(liveId, doctorId, atDoctorId, message, true, globalIncrId);
        } catch (Exception var10) {
            logger.log(Level.SEVERE, var10.getMessage(), var10);
        }

    }

    public List<Map.Entry<String, String>> getExclusiveMsg(Integer liveId, Integer doctorId) {
        String keyPrefix = "chat." + liveId + ".";
        String exclusiveMsgId = keyPrefix + doctorId;
        Map<String, String> result = this.command.hgetall(exclusiveMsgId);
        List<Map.Entry<String, String>> list = new ArrayList(result.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                String o1Id = ((String)o1.getKey()).substring(0, ((String)o1.getKey()).indexOf("."));
                String o2Id = ((String)o2.getKey()).substring(0, ((String)o2.getKey()).indexOf("."));
                return Integer.compare(Integer.valueOf(o1Id), Integer.valueOf(o2Id));
            }
        });
        return list;
    }

    public List<String> getMsgs(Integer liveId, Integer from, Integer to) {
        String keyPrefix = "chat." + liveId + ".";
        String globalMsgKeyZSet = keyPrefix + "global.msg.key.zset";
        String globalMsgKeyHash = keyPrefix + "global.msg.key.hash";
        Object result = new ArrayList();

        try {
            Set<String> fields = this.command.zrangeByScore(globalMsgKeyZSet, (double)to, (double)from);
            result = this.command.hmget(globalMsgKeyHash, (String[])fields.toArray(new String[fields.size()]));
        } catch (Exception var9) {
            logger.log(Level.SEVERE, var9.getMessage(), var9);
        }

        return (List)result;
    }

    public void saveQuestion(Integer liveId, Integer doctorId, String question, Long globalIncrId) {
        String questionsHashKey = "chat." + liveId + ".questions";
        String questionIDField = globalIncrId + "." + doctorId;

        try {
            this.command.hset(questionsHashKey, questionIDField, question);
            this.saveMsg(liveId, doctorId, question, globalIncrId);
        } catch (Exception var8) {
            logger.log(Level.SEVERE, var8.getMessage(), var8);
        }

    }

    public List<Map.Entry<String, String>> getQuestions(Integer liveId) {
        String questionsHashKey = "chat." + liveId + ".questions";
        Map<String, String> result = this.command.hgetall(questionsHashKey);
        List<Map.Entry<String, String>> list = new ArrayList(result.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                String o1Id = ((String)o1.getKey()).substring(0, ((String)o1.getKey()).indexOf("."));
                String o2Id = ((String)o2.getKey()).substring(0, ((String)o2.getKey()).indexOf("."));
                return Integer.compare(Integer.valueOf(o1Id), Integer.valueOf(o2Id));
            }
        });
        return list;
    }

    public Long getMsgCount(Integer liveId) {
        String keyPrefix = "chat." + liveId + ".";
        String globalMsgKeyHash = keyPrefix + "global.msg.key.hash";
        return Long.valueOf(this.command.get(globalMsgKeyHash));
    }
}
