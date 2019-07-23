package com.example.dcapp.account.view.itf;

public interface ICreatePasswordDialogView extends IView {


    /**
     * 显示注册成功
     */
    void showRegisterSnc();


    /**
     * 显示登录成功
     */
    void showLoginSuc();


    /**
     * 显示密码为空
     */
    void  showPasswordNull();


    /**
     * 显示两次驶入密码不一致
     */
    void showPasswordNotEqual();
}
