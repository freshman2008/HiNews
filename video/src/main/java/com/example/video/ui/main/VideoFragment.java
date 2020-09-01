package com.example.video.ui.main;

import android.util.Log;
import android.view.View;

import com.example.commonlib.mvp.BaseFragment;
import com.example.video.R;
import com.example.video.adapter.VideoListRvAdapter;
import com.example.video.bean.local.VideoItem;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.jzvd.JZMediaManager;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdMgr;

import static com.example.commonlib.utils.Consts.TAG;

public class VideoFragment extends BaseFragment<VideoPresenter> implements VideoContract.View {
    private RecyclerView mVideoListRV;
    private VideoListRvAdapter mVideoListAdapter;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initView() {
        mVideoListRV = getView().findViewById(R.id.video_list_rv);
        mVideoListRV.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mVideoListRV.setLayoutManager(mLayoutManager);
        mVideoListAdapter = new VideoListRvAdapter(getContext(), null);
        mVideoListRV.setAdapter(mVideoListAdapter);
        mVideoListRV.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(@NonNull View view) {
                Log.v("hello", "onChildViewAttachedToWindow:");
            }

            @Override
            public void onChildViewDetachedFromWindow(@NonNull View view) {
                Log.v("hello", "onChildViewDetachedFromWindow");
                Jzvd jzvd = view.findViewById(R.id.iv_video);
                if (jzvd != null && jzvd.jzDataSource.containsTheUrl(JZMediaManager.getCurrentUrl())) {
                    Jzvd currentJzvd = JzvdMgr.getCurrentJzvd();
                    if (currentJzvd != null && currentJzvd.currentScreen != Jzvd.SCREEN_WINDOW_FULLSCREEN) {
                        Jzvd.releaseAllVideos();
                    }
                }
            }
        });
    }

    @Override
    protected void initData() {
        mPresenter.getVideos();
    }

    @Override
    protected VideoPresenter createPresenter() {
        return new VideoPresenter();
    }

    @Override
    public void showVideos(final List<VideoItem> videoItems) {
        Log.i(TAG, "showVideos()");
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mVideoListAdapter.setVideoList(videoItems);
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.v("what", "onStop()");
        Jzvd.releaseAllVideos();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.v("what", "onPause()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v("what", "onDestroy()");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (!isVisibleToUser) {
            Log.v("what", "setUserVisibleHint(false)");
            Jzvd.releaseAllVideos();
        } else {
            Log.v("what", "setUserVisibleHint(true)");
        }
    }

    @Override
    public void showError(String message) {
        showToast(message);
    }
}
