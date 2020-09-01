package com.example.commonlib.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.commonlib.BaseApplication;

import java.util.Map;
import java.util.Set;

/**
 * @Description: SPUtils
 * @Author: Li Xiuliang
 * @CreateDate: 2020/8/14 15:05
 * @Version: 1.0
 */
public class SPUtils {
    private static SharedPreferences sp = BaseApplication.getContext().getSharedPreferences(Consts.DEFAULT_PREFS, Context.MODE_PRIVATE);

    public static void putBoolean(String key, Boolean value) {
        sp.edit().putBoolean(key, value).commit();
    }

    public static Boolean getBoolean(String key) {
        return sp.getBoolean(key, false);
    }

    public static void putString(String key, String value) {
        sp.edit().putString(key, value).commit();
    }

    public static String getString(String key) {
        return sp.getString(key, null);
    }

    public static void putInt(String key, int value) {
        sp.edit().putInt(key, value).commit();
    }

    public static int getInt(String key) {
        return sp.getInt(key, 0);
    }

    public static void putLong(String key, long value) {
        sp.edit().putLong(key, value).commit();
    }

    public static long getLong(String key) {
        return sp.getLong(key, 0L);
    }

    public static void putFload(String key, float value) {
        sp.edit().putFloat(key, value).commit();
    }

    public static float getFload(String key) {
        return sp.getFloat(key, 0f);
    }

    public static void putStringSet(String key, Set<String> value) {
        sp.edit().putStringSet(key, value).commit();
    }

    public static Set<String> getStringSet(String key) {
        return sp.getStringSet(key, null);
    }

    public static Map<String, ?> getAll() {
        return sp.getAll();
    }

    public static void remove(String key) {
        sp.edit().remove(key).commit();
    }

    public static Boolean contains(String key) {
        return sp.contains(key);
    }

}
