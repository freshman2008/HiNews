package com.example.commonlib.net.listener;


public interface NetCallback<T> {
    void onSuccess(T data);

    void onFailed(String errMsg);
}
