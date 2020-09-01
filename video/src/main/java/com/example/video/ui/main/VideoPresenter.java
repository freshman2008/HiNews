package com.example.video.ui.main;

import android.util.Log;

import com.example.commonlib.mvp.BasePresenter;
import com.example.commonlib.net.listener.NetCallback;
import com.example.video.bean.local.VideoItem;
import com.example.video.bean.response.GetVideoListResult;
import com.example.video.bean.response.ResultItem;

import java.util.ArrayList;
import java.util.List;

import static com.example.commonlib.utils.Consts.TAG;


public class VideoPresenter extends BasePresenter<VideoFragment, VideoModel> implements VideoContract.Presenter {
    @Override
    protected VideoModel initModel() {
        return new VideoModel();
    }

    @Override
    public void getVideos() {
        mModel.getVideos(new NetCallback<GetVideoListResult>() {
            @Override
            public void onSuccess(GetVideoListResult data) {
                Log.i(TAG, "onSuccess()");
                ResultItem[] result = data.getResult();
                if (result != null) {
                    List<VideoItem> videoItemList = new ArrayList<>();
                    for (ResultItem item : result) {
                        if (item.getType().equalsIgnoreCase("followCard")) {
                            ResultItem.DataItem dataItem = item.getData();
                            ResultItem.ContentData contentData = dataItem.getContent().getData();
                            VideoItem videoItem = new VideoItem(contentData.getTitle(),
                                    contentData.getDescription(),
                                    contentData.getPlayUrl(),
                                    contentData.getCover().getFeed(),
                                    contentData.getDate(),
                                    contentData.getProvider().getName(),
                                    contentData.getProvider().getIcon());
                            videoItemList.add(videoItem);
                        }
                    }
                    if (!videoItemList.isEmpty()) {
                        mView.showVideos(videoItemList);
                    }
                } else {
                    mView.showError("Videos get failed.");
                }
            }

            @Override
            public void onFailed(String errMsg) {
                Log.i(TAG, "onFailed()");
                mView.showError(errMsg);
            }
        });
    }
}
