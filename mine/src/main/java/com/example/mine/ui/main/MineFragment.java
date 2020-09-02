package com.example.mine.ui.main;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonlib.mvp.BaseFragment;
import com.example.mine.R;

@Route(path = "/mine/minefragment")
public class MineFragment extends BaseFragment<MinePresenter> {
    @Override
    protected int getLayoutResId() {
        return R.layout.mine_fragment_myinfo;
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
