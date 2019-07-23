package com.example.dcapp.account.presenter;

public interface ILoginDialogPresenter {


    /**
     *  登录
     * @param phone 手机号
     * @param password 密码
     */
    void requestLogin(String phone,String password);

}
