package com.demo.www.springbootdemo.module.async;

/**
 * Created on 2019/12/2 18:11
 * author:crs
 * Description:XXX
 */
public class NoticeSmsEvent extends  SmsEvent {

    public NoticeSmsEvent(Long smsId, String telphone, String content) {
        super(smsId, telphone, content);
    }



}
