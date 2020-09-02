package com.example.mine.ui.main;

import com.example.commonlib.mvp.BasePresenter;

public class MinePresenter extends BasePresenter<MineFragment, MineModel> {
    @Override
    protected MineModel initModel() {
        return new MineModel();
    }
}
