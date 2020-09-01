package com.example.commonlib.mvp;

abstract public class BasePresenter<V extends IBaseView, M extends IBaseModel> implements IBasePresenter {
    protected V mView = null;
    protected M mModel = null;

    public BasePresenter() {
        mModel = initModel();
    }

    protected abstract M initModel();

    @Override
    public void attachView(IBaseView view) {
        this.mView = (V)view;
    }

    @Override
    public void detachView() {
        if (mView != null) {
            mView = null;
        }
        mModel.unSubscribe();
    }
}
