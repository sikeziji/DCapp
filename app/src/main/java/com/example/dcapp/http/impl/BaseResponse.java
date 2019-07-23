package com.example.dcapp.http.impl;

import com.example.dcapp.http.IResponse;
public class BaseResponse implements IResponse {

    //设置状态值
    public static final  int STATE_UNKNOWN_ERROR = 10001;

    //设置成功状态值
    public static  final int STATE_OK = 200;

    //状态码
    private int code;

    //相应数据
    private String data;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(String data) {
        this.data = data;
    }

}
