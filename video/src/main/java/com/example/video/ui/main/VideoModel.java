package com.example.video.ui.main;

import com.example.commonlib.mvp.BaseModel;
import com.example.commonlib.net.MyObserver;
import com.example.commonlib.net.RetrofitManager;
import com.example.commonlib.net.listener.NetCallback;
import com.example.video.bean.response.GetVideoListResult;
import com.example.video.service.ServiceApi;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class VideoModel extends BaseModel<ServiceApi> implements VideoContract.Model {

    @Override
    public void getVideos(final NetCallback callback) {
        mTasks.add(mServiceApi.getVideos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new MyObserver<GetVideoListResult>() {
                    @Override
                    public void onNext(GetVideoListResult result) {
                        if (callback != null){
                            callback.onSuccess(result);
                        }
                    }
                }));
    }

    @Override
    protected ServiceApi createServiceApi() {
        return RetrofitManager.getInstance().getApi(ServiceApi.class);
    }
}
