package com.example.commonlib.net;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * @Description: OkHttpInterceptor
 * @Author: Li Xiuliang
 * @CreateDate: 2020/8/13 10:12
 * @Version: 1.0
 */
public class OkHttpInterceptor implements Interceptor {
    private static final String TAG = "net";

    //设置缓存有效期为1天
    private static final long CACHE_CONTROL_CACHE = 60 * 60 * 24;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        LogForRequest(request);

        Response response = chain.proceed(request);

        logForResponse(response);

        return response;
    }

    private void logForResponse(Response response) throws IOException {
        Log.v(TAG, "Response code: " + response.code());
        Log.v(TAG, "Response message: " + response.message());
        Log.v(TAG, "Response headers: " + response.headers().toString());
        Log.v(TAG, "Response protocol: " + response.protocol().toString());
//        Log.v(TAG, "Response body: " + response.body().string());// 直接调用response.body().string(), 因为调用该方法后数据流就关闭，之后再获取body数据时程序就可能会发生异常。
        ResponseBody body = response.peekBody(1024*1024);
        if (body != null){
            Log.e(TAG,"Response body: " + body.string());
        }
    }

    private void LogForRequest(Request request) {
        Log.v(TAG, "Request method: " + request.method());
        Log.v(TAG, "Request url: " + request.url().toString());
        Log.v(TAG, "Request headers: " + request.headers().toString());
//        Log.v(TAG, "Request body: " + request.body().toString());
        Log.v(TAG, "Request cacheControl: " + request.cacheControl().toString());
    }
}
