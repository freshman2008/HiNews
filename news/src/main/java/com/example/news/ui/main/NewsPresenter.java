package com.example.news.ui.main;

import android.util.Log;

import com.example.commonlib.mvp.BasePresenter;
import com.example.commonlib.net.listener.NetCallback;
import com.example.news.bean.response.GetNewsListResult;
import com.example.news.bean.response.NewsItem;

import java.util.Arrays;

import static androidx.constraintlayout.widget.Constraints.TAG;


public class NewsPresenter extends BasePresenter<NewsFragment, NewsModel> implements NewsContract.Presenter {
    @Override
    protected NewsModel initModel() {
        return new NewsModel();
    }

    @Override
    public void getNews() {
        mModel.getNews(new NetCallback<GetNewsListResult>() {

            @Override
            public void onSuccess(GetNewsListResult data) {
                Log.i(TAG, "onSuccess()");
                if (data != null && data.getError_code().equals("0")) {
                    NewsItem[] newsItemArray = data.getResult().getData();
                    mView.showNews(Arrays.asList(newsItemArray));
                } else {
                    mView.showError(data.getReason());
                }
            }

            @Override
            public void onFailed(String errMsg) {
                Log.i(TAG, "onFailed()");
                mView.showError(errMsg);
            }
        });
    }
}
