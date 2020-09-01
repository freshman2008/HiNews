package com.example.video.bean.response;

import com.example.video.bean.response.ResultItem;

public class GetVideoListResult {
    private int code;
    private String message;
    private ResultItem[] result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultItem[] getResult() {
        return result;
    }

    public void setResult(ResultItem[] result) {
        this.result = result;
    }
}
