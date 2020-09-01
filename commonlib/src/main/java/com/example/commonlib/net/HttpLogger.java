package com.example.commonlib.net;

import android.util.Log;

import com.example.commonlib.utils.JsonUtil;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @Description: HttpLogger
 * @Author: Li Xiuliang
 * @CreateDate: 2020/8/13 15:00
 * @Version: 1.0
 */
public class HttpLogger implements HttpLoggingInterceptor.Logger {
    private StringBuilder mMessage = new StringBuilder();

    @Override
    public void log(String message) {
        // 请求或者响应开始
        if (message.startsWith("--> POST")) {
            mMessage.setLength(0);
        }
        // 以{}或者[]形式的说明是响应结果的json数据，需要进行格式化
        if ((message.startsWith("{") && message.endsWith("}"))
                || (message.startsWith("[") && message.endsWith("]"))) {
            message = JsonUtil.formatJson(JsonUtil.decodeUnicode(message));
        }
        mMessage.append(message.concat("\n"));
        // 响应结束，打印整条日志
        if (message.startsWith("<-- END HTTP")) {
//            LogUtil.d(mMessage.toString());
            Log.d("hello", mMessage.toString());
        }
    }
}
