package com.example.dcapp.account.model;

import android.os.Handler;

import com.example.dcapp.common.storage.SharedPreferencesDao;
import com.example.dcapp.http.IHttpClient;

public class AccountManagerImpl implements  IAccountManager {

    // 网络请求库
    private IHttpClient httpClient;
    // 数据存储
    private SharedPreferencesDao sharedPreferencesDao;

    // 发送消息 handler
    private Handler handler;


    public AccountManagerImpl(IHttpClient httpClient,
                              SharedPreferencesDao sharedPreferencesDao) {
        this.httpClient = httpClient;
        this.sharedPreferencesDao = sharedPreferencesDao;
    }


    @Override
    public void fetchSMSCode(String phone) {

    }

    @Override
    public void checkSmsCode(String phone, String smsCode) {

    }

    @Override
    public void checkUserExist(String phone) {

    }

    @Override
    public void register(String phone, String password) {

    }

    @Override
    public void login(String phone, String password) {
        System.out.println("登录成功");
    }

    @Override
    public void loginByToken() {

    }

    @Override
    public boolean isLogin() {
        return false;
    }
}
