package com.demo.www.springbootdemo.module.async;

/**
 * Created on 2019/12/5 18:08
 * author:crs
 * Description:XXX
 */
public class TestAys extends SmsEvent {

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private boolean status;

    public TestAys(Long smsId, String telphone, String content) {
        super(smsId, telphone, content);
    }
}
