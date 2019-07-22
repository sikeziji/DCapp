package com.example.dcapp.http.impl;

import com.example.dcapp.http.IHttpClient;
import com.example.dcapp.http.IRequest;
import com.example.dcapp.http.IResponse;

import java.io.IOException;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpClientImpl implements IHttpClient {

    //初始化OkHttpClient
    OkHttpClient mOkHttpClient = new OkHttpClient.Builder().build();

    @Override
    public IResponse get(IRequest request, boolean forceCache) {
        /**
         * 解析业务参数
         */

        //设置请求方式
        request.setMethod(IRequest.GET);

        //设置请求头部
        Map<String,String> header = request.getHeader();

        //创建OKHttp的Request.Builder
        Request.Builder builder = new Request.Builder();

        for (String key : header.keySet()){
            //组装成OkHttp的Header
            builder.header(key,header.get(key));
        }

        //获取URL
        String url = request.getUrl();

        builder.url(url).get();

        Request okRequest = builder.build();

        //执行 okRequest
        return execute(okRequest);
    }

    /**
     * 请求执行过程
     * @param okRequest
     * @return
     */
    private IResponse execute(Request okRequest) {

        BaseResponse commonResponse = new BaseResponse();

        try {
            Response response = mOkHttpClient.newCall(okRequest).execute();
            commonResponse.setCode(response.code());
            String body = response.body().string();

            commonResponse.setData(body);

             /*Log.d("OkHttpClientImpl" ,String.format("Received response body: %s ",
                    body));*/

        } catch (IOException e) {
            e.printStackTrace();
            commonResponse.setCode(commonResponse.STATE_UNKNOWN_ERROR);
            commonResponse.setData(e.getMessage());
        }
        return commonResponse;

    }

    @Override
    public IResponse post(IRequest request, boolean forceCache) {
        //指定请求方式
        request.setMethod(IRequest.POST);

        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");

        RequestBody body = RequestBody.create(mediaType,request.getBody().toString());

        Map<String,String> header = request.getHeader();

        Request.Builder builder = new Request.Builder();

        for (String key: header.keySet()){
            builder.header(key,header.get(key));
        }

        builder.url(request.getUrl()).post(body);

        Request okRequest = builder.build();

        return execute(okRequest);


    }
}
