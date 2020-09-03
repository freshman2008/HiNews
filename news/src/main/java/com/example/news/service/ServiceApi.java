package com.example.news.service;

import com.example.news.bean.response.GetNewsListResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 创建用于描述网络请求的接口
 * 基于业务定义
 */
public interface ServiceApi {
    @GET("toutiao/index")
    Observable<GetNewsListResult> getNews(@Query("type") String type,
                                          @Query("key") String key);

//    @GET("https://api.apiopen.top/todayVideo")
//    Observable<GetVideoListResult> getVideos();
}
