package com.example.main.ui.home;

import com.example.commonlib.mvp.BasePresenter;

public class MainPresenter extends BasePresenter {
    @Override
    protected MainModel initModel() {
        return new MainModel();
    }
}
