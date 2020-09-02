package com.example.video.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.video.R;
import com.example.video.bean.local.VideoItem;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

public class VideoListRvAdapter extends RecyclerView.Adapter<VideoListRvAdapter.VideoListViewHolder> {
    private List<VideoItem> mVideoList = new ArrayList<>();
    private Context mContext;

    public VideoListRvAdapter(Context context, List<VideoItem> datas) {
        mContext = context;
        if (datas != null) {
            mVideoList.clear();
            mVideoList.addAll(datas);
        }
    }

    public void setVideoList(List<VideoItem> datas) {
        if (datas != null) {
            mVideoList.clear();
            mVideoList.addAll(datas);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public VideoListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_videos_item, viewGroup, false);
        return new VideoListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final VideoListViewHolder viewHolder, final int i) {
        if (!TextUtils.isEmpty(mVideoList.get(i).getProviderIcon())) {
            Glide.with(mContext).load(mVideoList.get(i).getProviderIcon()).into(viewHolder.ivProvider);
        }
        viewHolder.tvFrom.setText(mVideoList.get(i).getProviderName());
        viewHolder.tvTime.setText(mVideoList.get(i).getDate());

        viewHolder.jzvdStd.setUp(mVideoList.get(i).getPlayUrl(),
                mVideoList.get(i).getTitle(),
                Jzvd.SCREEN_WINDOW_NORMAL);
//        viewHolder.jzvdStd.thumbImageView.setImageURI(Uri.parse(mVideoList.get(i).getIcon())); //图片没有加载图片
        Glide.with(mContext).load(mVideoList.get(i).getIcon()).into(viewHolder.jzvdStd.thumbImageView);
    }

    @Override
    public int getItemCount() {
        return mVideoList.size();
    }

    static class VideoListViewHolder extends RecyclerView.ViewHolder {
        public JzvdStd jzvdStd;
        public ImageView ivProvider;
        public TextView tvFrom;
        public TextView tvTime;

        public VideoListViewHolder(@NonNull View itemView) {
            super(itemView);

            jzvdStd = itemView.findViewById(R.id.iv_video);
            ivProvider = itemView.findViewById(R.id.iv_provider);
            tvFrom = itemView.findViewById(R.id.tv_from);
            tvTime = itemView.findViewById(R.id.tv_play_time);
        }
    }
}
