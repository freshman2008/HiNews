package com.example.news.ui.main;

import com.example.commonlib.mvp.IBaseModel;
import com.example.commonlib.mvp.IBasePresenter;
import com.example.commonlib.mvp.IBaseView;
import com.example.commonlib.net.listener.NetCallback;
import com.example.news.bean.response.NewsItem;

import java.util.List;

public class NewsContract {
    interface View extends IBaseView {
        void showNews(List<NewsItem> newsList);
        void showError(String message);
    }

    interface Presenter extends IBasePresenter {
        void getNews();
    }

    interface Model extends IBaseModel {
        void getNews(NetCallback callback);
    }
}
