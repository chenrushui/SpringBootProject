package com.demo.www.springbootdemo.module.async;

/**
 * Created on 2019/12/2 18:10
 * author:crs
 * Description:SmsEvent
 */
public class SmsEvent {
    private Long smsId;
    private String telphone;
    private String content;

    public SmsEvent(Long smsId, String telphone, String content) {
        this.smsId = smsId;
        this.telphone = telphone;
        this.content = content;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getSmsId() {
        return smsId;
    }

    public void setSmsId(Long smsId) {
        this.smsId = smsId;
    }

    @Override
    public String toString() {
        return "SmsEvent{" +
                "smsId=" + smsId +
                ", telphone='" + telphone + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
