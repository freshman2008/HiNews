package com.example.commonlib.mvp;

import android.content.Context;

/**
 * IBaseView
 * 所有视图的公共接口
 */
public interface IBaseView {
    void showLoading();
    void hideLoading();
    Context getContext();
    void showToast(String message);
}
