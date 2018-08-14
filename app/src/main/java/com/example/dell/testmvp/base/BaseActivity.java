package com.example.dell.testmvp.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 高山仰止,景行行止.虽不能至,心向往之。
 * Created by de'l'l on 2018/8/14.
 */


public abstract class BaseActivity<P extends BasePresenter>extends AppCompatActivity {
    protected  P presenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        parsePresenter();
        presenter.attachView(this);
        initView();
        initData();
    }

    protected abstract int getLayoutId();
    protected abstract void initView();
    protected abstract void initData();
    private void parsePresenter(){
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        //获得第一个实现类中所有泛型参数的集合
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        //获得实现接口中第一个泛型的参数
        Class<P> tClass = (Class<P>) actualTypeArguments[0];
        try {
            //通过Java的动态代理来创建对象
            presenter = tClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
