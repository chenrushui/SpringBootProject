package com.yunque.www.springbootdemo.base;

import org.springframework.util.StringUtils;

public abstract class BaseDto {
    //图片存储oss
    private String ossPrefixUrl;
    //图片存储七牛
    private String sevenPrefixUrl;

    /**
     * 把基地址传递进来
     *
     * @param ossPrefixUrl
     * @param sevenPrefixUrl
     */
    public void setUrlHead(String ossPrefixUrl, String sevenPrefixUrl) {
        this.ossPrefixUrl = ossPrefixUrl;
        this.sevenPrefixUrl = sevenPrefixUrl;
    }

    /**
     * 如何拼接处理url?
     * 公共的内容在父类中处理
     *
     * @param url
     * @return
     */
    public String getUrl(String url) {
        if (StringUtils.isEmpty(url)) {
            return "";
        } else if (url.startsWith("/qiniu/")) {
            return this.sevenPrefixUrl == null ? url : this.sevenPrefixUrl + url;
        } else {
            return this.ossPrefixUrl == null ? url : this.ossPrefixUrl + url;
        }
    }

}
