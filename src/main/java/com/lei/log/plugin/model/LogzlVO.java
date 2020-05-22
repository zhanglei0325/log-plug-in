package com.lei.log.plugin.model;

import java.io.Serializable;

/**
 * @author: zl
 * @date: 2020/5/21 11:23
 * @description: 日志默认格式实体
 */
public class LogzlVO implements Serializable {

    /**
     * 日志标题
     */
    private String title;
    /**
     * 日志名称
     */
    private String name;
    /**
     * 日志类型
     */
    private Integer type;
    /**
     * 请求地址
     */
    private String url;
    /**
     * 请求方法
     */
    private String method;
    /**
     * IP地址
     */
    private String ip;
    /**
     * 系统类型
     */
    private String systemName;
    /**
     * 浏览器类型
     */
    private String browserName;
    /**
     * 参数详情
     */
    private String params;
    /**
     * 返回结果
     */
    private String results;

    public LogzlVO(String title, String name, Integer type, String url, String method, String ip, String systemName, String browserName, String params, String results) {
        this.title = title;
        this.name = name;
        this.type = type;
        this.url = url;
        this.method = method;
        this.ip = ip;
        this.systemName = systemName;
        this.browserName = browserName;
        this.params = params;
        this.results = results;
    }

    public LogzlVO() {
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "LogzlVO{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", ip='" + ip + '\'' +
                ", systemName='" + systemName + '\'' +
                ", browserName='" + browserName + '\'' +
                ", params='" + params + '\'' +
                ", results='" + results + '\'' +
                '}';
    }
}
