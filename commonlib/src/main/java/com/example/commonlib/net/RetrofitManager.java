package com.example.commonlib.net;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private static RetrofitManager mInstance = null;
    private Retrofit mRetrofit = null;
    private Context mContext = null;

    private RetrofitManager() {
        // 创建默认OKHttpClient
//        OkHttpClient.Builder client = new OkHttpClient.Builder();
        OkHttpClient okHttpClient = new OkHttpClient
                .Builder()
                .addInterceptor(AddHeaderInterceptor())
                .addInterceptor(InitLogInterceptor())
//                .connectTimeout(30, TimeUnit.SECONDS)
//                .readTimeout(30, TimeUnit.SECONDS)
//                .writeTimeout(30, TimeUnit.SECONDS)
                .build();

        mRetrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 支持rxjava
                .baseUrl("https://v.juhe.cn")
                .build();
    }

    private Interceptor AddHeaderInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if(request.method().equals("POST")) {
                    Buffer sink = new Buffer();
                    request.body().writeTo(sink);
                    String json = sink.readString(Charset.defaultCharset());
                    Log.v("hello", "request body: " + json);
                }
                return chain.proceed(request);
            }
        };
    }

    private Interceptor InitLogInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLogger());
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    public static RetrofitManager getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitManager.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * 初始化
     * 传入上下文与定制的retrofit
     *
     * @param context
     * @param retrofit
     */
    public void init(Context context, Retrofit retrofit) {
        this.mContext = context;
        if (retrofit != null) {
            this.mRetrofit = retrofit;
        }
    }

    public Retrofit getRetrofit( ) {
        return mRetrofit;
    }

    public <T> T getApi(Class<T> clazz) {
        return mRetrofit.create(clazz);
    }
}
