package com.example.commonlib.mvp;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.commonlib.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


abstract public class BaseActivity<P extends IBasePresenter> extends AppCompatActivity implements IBaseView {
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        if (mPresenter != null) {
            mPresenter = createPresenter();
            mPresenter.attachView(this);
        }

        initLib();
        initView();
        initData();
    }

    protected void initLib() {
        ARouter.getInstance().inject(this);
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayoutResId();

    protected abstract P createPresenter();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        showToast(getString(R.string.loading_tv));
    }

    @Override
    public void hideLoading() {

    }

    @Override
    public Context getContext() {
        return this.getApplicationContext();
    }
}
