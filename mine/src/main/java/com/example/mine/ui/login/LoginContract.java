package com.example.mine.ui.login;

import com.example.commonlib.mvp.IBaseModel;
import com.example.commonlib.mvp.IBasePresenter;
import com.example.commonlib.mvp.IBaseView;
import com.example.commonlib.net.listener.NetCallback;
import com.example.mine.bean.LoginResult;

public class LoginContract {
    interface View extends IBaseView {
        void showLoginResult(LoginResult result);
        void showError(String message);
    }

    interface Presenter extends IBasePresenter {
        void login(String username, String password);
    }

    interface Model extends IBaseModel {
        void login(String username, String password, NetCallback callback);
    }
}
