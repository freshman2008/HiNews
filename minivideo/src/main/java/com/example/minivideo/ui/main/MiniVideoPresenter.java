package com.example.minivideo.ui.main;

import com.example.commonlib.mvp.BasePresenter;

public class MiniVideoPresenter extends BasePresenter<MiniVideoFragment, MiniVideoModel> {
    @Override
    protected MiniVideoModel initModel() {
        return new MiniVideoModel();
    }
}
