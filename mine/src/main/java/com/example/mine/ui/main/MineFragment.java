package com.example.mine.ui.main;

import com.example.commonlib.mvp.BaseFragment;
import com.example.mine.R;

public class MineFragment extends BaseFragment<MinePresenter> {
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_myinfo;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
    }

    @Override
    protected MinePresenter createPresenter() {
        return new MinePresenter();
    }
}
