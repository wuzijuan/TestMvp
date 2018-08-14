package com.example.dell.testmvp;

import com.example.dell.testmvp.entity.NewsBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 高山仰止,景行行止.虽不能至,心向往之。
 * Created by de'l'l on 2018/8/14.
 */


public interface ApiService {
    //业务方法
    @FormUrlEncoded
    @POST(Urls.NEWS)
    rx.Observable<NewsBean> newsList(@Field("type") String type, @Field("key") String key);
}
