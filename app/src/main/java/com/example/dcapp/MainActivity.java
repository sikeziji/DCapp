package com.example.dcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.dcapp.account.view.LoginDialog;
import com.example.dcapp.http.IResponse;
import com.example.dcapp.http.impl.BaseRequest;
import com.example.dcapp.http.impl.OkHttpClientImpl;

import okhttp3.Request;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//
//        BaseRequest request = new BaseRequest("www.baidu.com");
//
//        IResponse iResponse =  new OkHttpClientImpl().get(request,false);
//
//        System.out.println("request = " + request.toString());
//        System.out.println("iResponse = " + iResponse.toString());
//

        new LoginDialog(this,"15138963060").show();

    }
}
