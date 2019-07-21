package com.example.dcapp;

import org.junit.Test;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    /**
     * 测试 oKHttp Get方法
     */
    @Test
    public void testGet() {
        //创建一个OKHttpClient 对象
        OkHttpClient client = new OkHttpClient();
        //创建一个Request对象
        Request request = new Request.Builder().url("http://httpbin.org/get?id=id").build();
        //OkHttpClient 执行 Request
        try {
            Response response = client.newCall(request).execute();
            System.out.println("response = " + response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    /**
     * 测试 OkHttp Post方法
     */
    @Test
    public  void  testPost(){
        //创建OKhttpClient对象
        OkHttpClient client = new OkHttpClient();
        //设置格式
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        //创建RequestBody
        RequestBody requestBody = RequestBody.create(mediaType, "{\"name\": \"dalimao\"}");
        //创建Request 对象
        Request request = new  Request.Builder()
                .url("http://httpbin.org/post")// 请求行
                //.header(); // 请求头
                .post(requestBody) // 请求体
                .build();


        try {
            Response response = client.newCall(request).execute();
            System.out.println("response:" + response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}