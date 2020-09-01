package com.example.video.bean.local;

public class VideoItem {
    private String title;
    private String description;
    private String playUrl;
    private String icon;
    private String date;
    private String providerName;
    private String providerIcon;

    public VideoItem(String title, String description, String playUrl, String icon, String date, String providerName, String providerIcon) {
        this.title = title;
        this.description = description;
        this.playUrl = playUrl;
        this.icon = icon;
        this.date = date;
        this.providerName = providerName;
        this.providerIcon = providerIcon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderIcon() {
        return providerIcon;
    }

    public void setProviderIcon(String providerIcon) {
        this.providerIcon = providerIcon;
    }
}
