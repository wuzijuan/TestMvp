package com.example.dell.testmvp;

import com.example.dell.testmvp.base.BasePresenter;
import com.example.dell.testmvp.base.BaseView;
import com.example.dell.testmvp.entity.NewsBean;

/**
 * 高山仰止,景行行止.虽不能至,心向往之。
 * Created by de'l'l on 2018/8/14.
 */


public interface MyContract {

    interface View extends BaseView {
      void showList(NewsBean bean);
    }


    interface Presenter extends BasePresenter<View> {
        void getData(String type,String key);

        
    }

}