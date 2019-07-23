package com.example.dcapp.splash;

import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dcapp.MainActivity;
import com.example.dcapp.R;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            final AnimatedVectorDrawable anim1 = (AnimatedVectorDrawable) this.getResources().getDrawable(R.drawable.anim);
            final ImageView logo = ((ImageView) findViewById(R.id.logo));
            logo.setImageDrawable(anim1);
            anim1.start();
        }
        /**
         * 延时 3 秒然后跳转到 main 页面
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 3000) ;
    }
}
