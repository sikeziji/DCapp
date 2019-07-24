package com.example.dcapp.account.presenter;

import com.example.dcapp.account.model.IAccountManager;
import com.example.dcapp.account.view.itf.ILoginView;

/**
 * 登录Dialog数据实现类
 */
public class LoginDialogPresenterImpl implements ILoginDialogPresenter {


    private ILoginView view;

    private  IAccountManager iAccountManager;


    public  LoginDialogPresenterImpl(ILoginView view, IAccountManager iAccountManager){
        this.view = view;
        this.iAccountManager = iAccountManager;
    }


    @Override
    public void requestLogin(String phone, String password) {
        iAccountManager.login(phone,password);
    }
}
