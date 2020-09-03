package com.example.news.bean.response;

public class NewsList {
    private String stat;
    private NewsItem[] data;

    public NewsList() {
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public NewsItem[] getData() {
        return data;
    }

    public void setData(NewsItem[] data) {
        this.data = data;
    }
}
