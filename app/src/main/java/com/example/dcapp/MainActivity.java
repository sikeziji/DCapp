package com.example.dcapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dcapp.materiallogin.AActivityOne;

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

        Intent intent = new Intent(this,AActivityOne.class);
        startActivity(intent);

    }
}
