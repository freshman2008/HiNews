package com.example.video.ui.main;

import com.example.commonlib.mvp.IBaseModel;
import com.example.commonlib.mvp.IBasePresenter;
import com.example.commonlib.mvp.IBaseView;
import com.example.commonlib.net.listener.NetCallback;
import com.example.video.bean.local.VideoItem;

import java.util.List;

public class VideoContract {
    interface View extends IBaseView {
        void showVideos(List<VideoItem> newsList);
        void showError(String message);
    }

    interface Presenter extends IBasePresenter {
        void getVideos();
    }

    interface Model extends IBaseModel {
        void getVideos(NetCallback callback);
    }
}
