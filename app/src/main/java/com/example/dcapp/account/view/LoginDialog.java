package com.example.dcapp.account.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dcapp.MainActivity;
import com.example.dcapp.MyTaxiApplication;
import com.example.dcapp.R;
import com.example.dcapp.account.model.AccountManagerImpl;
import com.example.dcapp.account.model.IAccountManager;
import com.example.dcapp.account.presenter.ILoginDialogPresenter;
import com.example.dcapp.account.presenter.LoginDialogPresenterImpl;
import com.example.dcapp.account.view.itf.ILoginView;
import com.example.dcapp.common.storage.SharedPreferencesDao;
import com.example.dcapp.http.IHttpClient;
import com.example.dcapp.http.impl.OkHttpClientImpl;

public class LoginDialog extends Dialog implements ILoginView {


    private String mPhoneStr;
    //提示
    private TextView mTips;
    //等待框
    private View mLoading;
    //按钮
    private Button mBtnConfirm;
    //手机号
    private TextView mPhone;
    //密码输入框
    private EditText mPw;


    private ILoginDialogPresenter mPresenter;

    //主activity
    private MainActivity mainActivity;

    private View root = null;

    private ImageView iv ;


    public LoginDialog(MainActivity activity, String phone) {
        //设置默认样式
        this(activity, R.style.Dialog);
        mPhoneStr = phone;
        IHttpClient httpClient = new OkHttpClientImpl();

        //TODO 初始化sharePreFerence工具类
        SharedPreferencesDao dao =
                new SharedPreferencesDao(MyTaxiApplication.getInstance(),
                        SharedPreferencesDao.FILE_ACCOUNT);

        //TODO 初始化 IAccountManager： 帐号相关业务逻辑抽象
        IAccountManager accountManager = new AccountManagerImpl(httpClient, dao);
        // TODO 初始化 LoginDialogPresenterImpl
        mPresenter = new LoginDialogPresenterImpl(this, accountManager);
        mainActivity = activity;

    }

    public LoginDialog(Context context, int themeResId) {
        super(context, themeResId);
    }


    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        root = inflater.inflate(R.layout.dialog_login_input,null);
        setContentView(root);
        initView();


        //  TODO 注册 Presenter

    }

    private void initView() {
        mPhone = (TextView) findViewById(R.id.phone);
        mPw = (EditText) findViewById(R.id.password);
        mBtnConfirm = (Button) findViewById(R.id.btn_confirm);
        mLoading = findViewById(R.id.loading);
        mTips = findViewById(R.id.tips);
        iv = findViewById(R.id.close);


        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });


        mBtnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });
        mPhone.setText(mPhoneStr);


    }

    private void submit() {

        String password = mPw.getText().toString();
        //  TODO 网络请求登录
        mPresenter.requestLogin(mPhoneStr, password);
    }

    @Override
    public void dismiss() {
        super.dismiss();

        //TODO 注销 Presenter

    }

    /**
     * 显示／隐藏 loading
     * @param show
     */
    private void showOrHideLoading(boolean show) {
        if (show) {
            mLoading.setVisibility(View.VISIBLE);
            mBtnConfirm.setVisibility(View.GONE);
        } else {
            mLoading.setVisibility(View.GONE);
            mBtnConfirm.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showLoginSnc() {
        showOrHideLoading(false);
        mTips.setVisibility(View.VISIBLE);
        mTips.setTextColor(getContext().getResources().getColor(R.color.color_text_normal));
        mTips.setText(getContext().getString(R.string.login_suc));
//        ToastUtil.show(getContext(), getContext().getString(R.string.login_suc));
//        mainActivity.showLoginSuc();
        dismiss();

    }

    @Override
    public void showLoading() {
        showOrHideLoading(true);
    }

    @Override
    public void showError(int code, String msg) {

        //TODO 设置不同模式的错误类型

//        switch (code) {
//            case IAccountManager.PW_ERROR:
//                // 密码错误
//                showPasswordError();
//                break;
//            case IAccountManager.SERVER_FAIL:
//                // 服务器错误
//                showServerError();
//                break;
//        }
    }

    /**
     *  显示服服务器出错
     */

    private void showServerError() {
        showOrHideLoading(false);
        mTips.setVisibility(View.VISIBLE);
        mTips.setTextColor(getContext().getResources().getColor(R.color.error_red));
        mTips.setText(getContext().getString(R.string.error_server));
    }


    /**
     * 密码错误
     */
    private void showPasswordError() {
        showOrHideLoading(false);
        mTips.setVisibility(View.VISIBLE);
        mTips.setTextColor(getContext().getResources().getColor(R.color.error_red));
        mTips.setText(getContext().getString(R.string.password_error));
    }
}
