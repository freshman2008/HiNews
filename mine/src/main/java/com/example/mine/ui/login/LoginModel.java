package com.example.mine.ui.login;

import com.example.commonlib.mvp.BaseModel;
import com.example.commonlib.mvp.IBaseModel;
import com.example.commonlib.net.MyObserver;
import com.example.commonlib.net.RetrofitManager;
import com.example.commonlib.net.listener.NetCallback;
import com.example.mine.bean.LoginResult;
import com.example.mine.service.ServiceApi;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author: Li Xiuliang
 * @date: 2020/9/2 18:09
 */
public class LoginModel extends BaseModel<ServiceApi> implements LoginContract.Model{
    @Override
    protected ServiceApi createServiceApi() {
        return RetrofitManager.getInstance().getApi(ServiceApi.class);
    }

    @Override
    public void login(String username, String password, final NetCallback callback) {
        mTasks.add(mServiceApi.login(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new MyObserver<LoginResult>() {
                    @Override
                    public void onNext(LoginResult result) {
                        if (callback != null) {
                            callback.onSuccess(result);
                        }
                    }
                }));
    }
}