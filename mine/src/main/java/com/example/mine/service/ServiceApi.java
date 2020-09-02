package com.example.mine.service;

import com.example.mine.bean.LoginResult;

import io.reactivex.Observable;
import retrofit2.http.POST;

/**
 * 创建用于描述网络请求的接口
 * 基于业务定义
 */
public interface ServiceApi {
    @POST("https://mytestserver.com/login")
    Observable<LoginResult> login(String username, String password);
}
