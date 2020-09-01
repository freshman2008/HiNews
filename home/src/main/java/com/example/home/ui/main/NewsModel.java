package com.example.home.ui.main;

import com.example.commonlib.mvp.BaseModel;
import com.example.commonlib.net.MyObserver;
import com.example.commonlib.net.RetrofitManager;
import com.example.commonlib.net.listener.NetCallback;
import com.example.home.bean.response.GetNewsListResult;
import com.example.home.service.ServiceApi;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NewsModel extends BaseModel<ServiceApi> implements NewsContract.Model {

    @Override
    public void getNews(final NetCallback callback) {
        mTasks.add(mServiceApi.getNews("top", "58ff2000704bbf8e31ce031c1b555a33")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new MyObserver<GetNewsListResult>() {
                    @Override
                    public void onNext(GetNewsListResult getNewsListResult) {
                        if (callback != null){
                            callback.onSuccess(getNewsListResult);
                        }
                    }
                }));
    }

    @Override
    protected ServiceApi createServiceApi() {
        return RetrofitManager.getInstance().getApi(ServiceApi.class);
    }
}
