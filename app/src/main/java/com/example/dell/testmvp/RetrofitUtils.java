package com.example.dell.testmvp;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {

    private static RetrofitUtils retrofitUtils;

    private Retrofit retrofit;
    private RetrofitUtils(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASEURL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetrofitUtils getInstance(){
        if (retrofitUtils == null){
            synchronized (RetrofitUtils.class){
                if (retrofitUtils == null)
                    retrofitUtils = new RetrofitUtils();
            }
        }
        return retrofitUtils;
    }


    public ApiService getHomeService(){
        return retrofit.create(ApiService.class);
    }


}
