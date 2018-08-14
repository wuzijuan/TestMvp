package com.example.dell.testmvp;


import android.util.Log;

import com.example.dell.testmvp.entity.NewsBean;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by TMVPHelper on 2018/08/14
 */
public class MyPresenter implements MyContract.Presenter {
    private MyContract.View view;
    @Override
    public void getData(String type, String key) {
        RetrofitUtils.getInstance().getHomeService()
                .newsList(type, key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<NewsBean>() {
                    @Override
                    public void call(NewsBean bean) {
                        if (view != null) {
                            view.showList(bean);
                        }

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.e("错误","cuowu");
                    }
                });
    }


    @Override
    public void attachView(MyContract.View view) {
        this.view=view;
    }

    @Override
    public void detachView() {
        this.view=null;

    }
}