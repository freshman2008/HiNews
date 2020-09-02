package com.example.minivideo.ui.main;

import android.net.Uri;
import android.widget.MediaController;
import android.widget.VideoView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonlib.mvp.BaseFragment;
import com.example.minivideo.R;

@Route(path = "/minivideo/minivideofragment")
public class MiniVideoFragment extends BaseFragment<MiniVideoPresenter> {
    private VideoView videoView;

    @Override
    protected int getLayoutResId() {
        return R.layout.minivideo_fragment_minivideo;
    }

    @Override
    protected void initView() {
        videoView = getView().findViewById(R.id.sv_video);
        videoView.setVideoURI(Uri.parse("http://ali.cdn.kaiyanapp.com/1510993954967_61069_480x270.mp4?auth_key=1596953716-0-0-a6179b5af40fdc34b3ede095d2729fd1"));
        MediaController mediaController = new MediaController(getContext());
        videoView.setMediaController(mediaController);
        videoView.start();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected MiniVideoPresenter createPresenter() {
        return new MiniVideoPresenter();
    }
}
