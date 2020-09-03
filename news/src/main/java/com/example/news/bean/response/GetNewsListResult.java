package com.example.news.bean.response;

public class GetNewsListResult {
    private String reason;
    private String error_code;
    private NewsList result;

    public GetNewsListResult() {
        reason = "default reason";
        error_code = "10086";
        result = null;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public NewsList getResult() {
        return result;
    }

    public void setResult(NewsList result) {
        this.result = result;
    }
}
