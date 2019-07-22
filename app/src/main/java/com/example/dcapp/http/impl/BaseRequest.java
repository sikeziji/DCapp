package com.example.dcapp.http.impl;

import com.example.dcapp.http.IRequest;
import com.example.dcapp.http.IResponse;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class BaseRequest implements IRequest {

    private String method = POST;
    private String url;
    private Map<String, String> header;
    private Map<String, Object> body;


    public BaseRequest(String url) {
        /**
         * 公共参数及头部信息
         */
        this.url = url;
        header = new HashMap<>();
        body = new HashMap<>();
//        header.put("X-Bmob-Application-Id","");
//        header.put("X-Bmob-REST-Key","");
    }


    @Override
    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public void setHeader(String key, String value) {
        header.put(key, value);
    }

    @Override
    public void setBody(String key, String value) {
        body.put(key, value);
    }

    @Override
    public String getUrl() {
        if (GET.equals(method)) {
            //组装Get请求参数
            for (String key : body.keySet()) {
                url = url.replace("${" + key + "}", body.get(key).toString());
            }
        }
        return url;
    }

    @Override
    public Map<String, String> getHeader() {
        return header;
    }

    @Override
    public Object getBody() {
        if (body != null) {
            // 组装 POST 方法请求参数
            return new Gson().toJson(this.body, HashMap.class);
        } else {
            return  "{}";
        }
    }
}
