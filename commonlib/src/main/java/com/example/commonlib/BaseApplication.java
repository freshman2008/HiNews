package com.example.commonlib;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @Description: BaseApplication
 * @Author: Li Xiuliang
 * @CreateDate: 2020/8/14 17:31
 * @Version: 1.0
 */
public class BaseApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

        initARouter(this);
    }

    private void initARouter(Application application) {
        if (BuildConfig.DEBUG) {
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(application);
    }

    public static Context getContext() {
        return mContext;
    }
}
