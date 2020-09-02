package com.example.mine.ui.login;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonlib.mvp.BaseActivity;
import com.example.commonlib.mvp.IBasePresenter;
import com.example.mine.R;
import com.example.mine.bean.LoginResult;

/**
 * @author: Li Xiuliang
 * @date: 2020/9/2 18:09
 */

@Route(path = "/mine/login")
public class LoginActivity extends BaseActivity implements LoginContract.View {
    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.mine_activity_login;
    }

    @Override
    protected IBasePresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void showLoginResult(LoginResult result) {
        showToast(result.getMessage());
    }

    @Override
    public void showError(String message) {

    }
}
