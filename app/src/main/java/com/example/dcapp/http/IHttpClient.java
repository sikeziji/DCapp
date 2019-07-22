package com.example.dcapp.http;


/**
 * HttpClient 抽象接口
 */
public interface IHttpClient {


    /**
     * get 请求
     * @param request
     * @param forceCache
     * @return
     */
    IResponse get(IRequest request,boolean forceCache);



    /**
     * post 请求
     * @param request
     * @param forceCache
     * @return
     */
    IResponse post(IRequest request, boolean forceCache);

}
