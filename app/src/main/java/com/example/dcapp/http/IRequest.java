package com.example.dcapp.http;

import java.util.Map;

public interface IRequest {


    //Post 模式
    public static final String POST = "POST";
    //Get 模式
    public static final String GET = "GET";

    /**
     * 设置指定格式
     *
     * @param method
     */
    void setMethod(String method);


    /**
     * 指定请求头部
     *
     * @param key
     * @param value
     */
    void setHeader(String key, String value);


    /**
     * 指定请求参数
     *
     * @param key
     * @param value
     */
    void setBody(String key, String value);


    /**
     * 提供给执行库请求使用的Url
     *
     * @return
     */
    String getUrl();


    /**
     * 提供给执行库请求头部
     *
     * @return
     */
    Map<String, String> getHeader();


    /**
     * 提供给执行库请求参数
     *
     * @return
     */
    Object getBody();


}
