package com.example.commonlib;

import android.app.Application;
import android.content.Context;

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
    }

    public static Context getContext() {
        return mContext;
    }
}
