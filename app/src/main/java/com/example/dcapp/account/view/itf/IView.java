package com.example.dcapp.account.view.itf;

public interface IView {


    /**
     * 显示loading
     */
    void showLoading();


    /**
     * 显示错误
     * @param code
     * @param msg
     */
    void  showError(int code,String msg);

}
