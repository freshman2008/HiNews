package com.example.video.bean.response;

public class ResultItem {
    private DataItem data;
    private int adIndex;
    private String tag;
    private int id;
    private String type;

    public DataItem getData() {
        return data;
    }

    public void setData(DataItem data) {
        this.data = data;
    }

    public int getAdIndex() {
        return adIndex;
    }

    public void setAdIndex(int adIndex) {
        this.adIndex = adIndex;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class DataItem {
        private String dataType;
        private DataContent content;

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public DataContent getContent() {
            return content;
        }

        public void setContent(DataContent content) {
            this.content = content;
        }
    }

    public static class DataContent {
        private ContentData data;
        private int adIndex;
        private String tag;
        private int id;
        private String type;

        public ContentData getData() {
            return data;
        }

        public void setData(ContentData data) {
            this.data = data;
        }

        public int getAdIndex() {
            return adIndex;
        }

        public void setAdIndex(int adIndex) {
            this.adIndex = adIndex;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static class ContentData {
        private String date;
        private String title;
        private String description;
        private String playUrl;
        private ContentCover cover;
        private VideoContentProvider provider;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
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

        public ContentCover getCover() {
            return cover;
        }

        public void setCover(ContentCover cover) {
            this.cover = cover;
        }

        public VideoContentProvider getProvider() {
            return provider;
        }

        public void setProvider(VideoContentProvider provider) {
            this.provider = provider;
        }
    }

    public static class ContentCover {
        private String feed;
        private String detail;

        public String getFeed() {
            return feed;
        }

        public void setFeed(String feed) {
            this.feed = feed;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }

    public static class VideoContentProvider {
        private String name;
        private String icon;
        private String alias;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }
    }
}
