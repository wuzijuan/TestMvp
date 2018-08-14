package com.example.dell.testmvp;
import android.util.Log;
import com.example.dell.testmvp.base.BaseActivity;
import com.example.dell.testmvp.entity.NewsBean;

import java.util.List;
public class MainActivity extends BaseActivity<MyPresenter>implements MyContract.View {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
    @Override
    protected void initView() {

    }
    @Override
    public void showList(NewsBean bean) {
        List<NewsBean.ResultBean.DataBean> data = bean.getResult().getData();
        for (int i = 0; i <data.size() ; i++) {
            String author_name = data.get(i).getAuthor_name();
            Log.e("aaaaaa",author_name);
        }
    }
    @Override
    protected void initData() {
        presenter.getData("yule","96e58c8794a6f63762f598aba4baf3b4");
    }
    @Override
    public void showMsg(String msg) {

    }
}
