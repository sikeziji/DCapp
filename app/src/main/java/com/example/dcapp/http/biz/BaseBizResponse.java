package com.example.dcapp.http.biz;

public class BaseBizResponse {

    public static final int STATE_OK = 200;

    //密码错误
    public static final int STATE_PW_ERR = 100005;

    // token 无效/过期
    public static final int STATE_TOKEN_INVALID = 100006;

    //用户已存在
    public  static  int STATE_USER_EXIST = 100003;

    //用户不存在
    public static int state_user_not_exist = 100002;
    //状态码
    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
