package com.example.video;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.video.R;
import com.example.video.ui.main.VideoFragment;

public class VideoActivity extends AppCompatActivity {
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        frameLayout = findViewById(R.id.news_fragment);

        init();
    }

    private void init() {
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        if (BuildConfig.DEBUG) {
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        // 尽可能早，推荐在Application中初始化
        ARouter.init(getApplication());
        FragmentManager fm = getSupportFragmentManager();
        if(fm != null) {
            Fragment fragment = fm.findFragmentById(R.id.news_fragment);
            if(fragment == null){
                fragment = new VideoFragment();
                fm.beginTransaction().add(R.id.news_fragment, fragment).commit();
            }
        }

    }
}
