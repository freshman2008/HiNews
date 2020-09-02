package com.example.mine.ui.login;

import android.util.Log;

import com.example.commonlib.mvp.BasePresenter;
import com.example.commonlib.net.listener.NetCallback;
import com.example.mine.bean.LoginResult;

/**
 * @author: Li Xiuliang
 * @date: 2020/9/2 18:21
 */
public class LoginPresenter extends BasePresenter<LoginActivity, LoginModel> implements LoginContract.Presenter {
    @Override
    protected LoginModel initModel() {
        return new LoginModel();
    }

    @Override
    public void login(String username, String password) {
        mModel.login(username, password, new NetCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult data) {
                mView.showLoginResult(data);
            }

            @Override
            public void onFailed(String errMsg) {
                mView.showError(errMsg);
            }
        });
    }
}
