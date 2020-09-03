package com.example.main.ui.splash;

import android.os.Bundle;
import android.os.Handler;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.commonlib.utils.ARouterConstants;
import com.example.main.R;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author: Li Xiuliang
 * @date: 2020/9/3 17:25
 */
public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGHT = 3000;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_splash);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ARouter.getInstance().build(ARouterConstants.MAIN.MAIN_ACTIVITY).navigation();
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGHT);

    }
}