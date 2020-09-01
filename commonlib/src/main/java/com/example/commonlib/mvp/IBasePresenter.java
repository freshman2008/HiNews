package com.example.commonlib.mvp;

public interface IBasePresenter {
    void attachView(IBaseView view);
    void detachView();
}
