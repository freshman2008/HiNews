package com.example.hinews;

import android.view.KeyEvent;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.example.commonlib.mvp.BaseActivity;
import com.example.commonlib.view.BottomNaviBar;
import com.example.commonlib.view.NoScrollViewPager;
import com.example.hinews.adapter.MainPagerAdapter;
import com.example.home.ui.main.NewsFragment;
import com.example.mine.ui.main.MineFragment;
import com.example.minivideo.ui.main.MiniVideoFragment;
import com.example.video.ui.main.VideoFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;

public class MainActivity extends BaseActivity<MainPresenter> {
    private BottomNaviBar bottomNavigationBar;
    private NoScrollViewPager mViewPager;
    //声明一个long类型变量：用于存放上一点击“返回键”的时刻
    private long mExitTime;

    @Override
    protected void initData() {

    }

    public void initView() {
        bottomNavigationBar = findViewById(R.id.bottom_navi_bar);
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {//这里也可以使用SimpleOnTabSelectedListener
            @Override
            public void onTabSelected(int position) {//未选中 -> 选中
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(int position) {//选中 -> 未选中
            }

            @Override
            public void onTabReselected(int position) {//选中 -> 选中
            }
        });

        mViewPager = findViewById(R.id.main_vp);
        List<Fragment> fragmentList = new ArrayList<>();
        NewsFragment fragment1 = new NewsFragment();

        VideoFragment fragment2 = new VideoFragment();
        MiniVideoFragment fragment3 = new MiniVideoFragment();
        MineFragment fragment4 = new MineFragment();
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);
        fragmentList.add(fragment3);
        fragmentList.add(fragment4);
        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        mainPagerAdapter.setList(fragmentList);
        mViewPager.setAdapter(mainPagerAdapter);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //判断用户是否点击了“返回键”
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //与上次点击返回键时刻作差
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                //大于2000ms则认为是误操作，使用Toast进行提示
//                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                showToast(getString(R.string.press_again_to_exit));
                //并记录下本次点击“返回键”的时刻，以便下次进行判断
                mExitTime = System.currentTimeMillis();
            } else {
                //小于2000ms则认为是用户确实希望退出程序-调用System.exit()方法进行退出
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
