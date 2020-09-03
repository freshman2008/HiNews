package com.example.news.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.commonlib.adapter.BaseRecyclerViewAdapter;
import com.example.news.R;
import com.example.news.bean.response.NewsItem;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.news.R;

public class NewsListRvAdapter extends BaseRecyclerViewAdapter<NewsItem, NewsListRvAdapter.NewsListViewHolder> {
    private Context mContext;

    public NewsListRvAdapter(Context context, List<NewsItem> datas) {
        mContext = context;

        if (datas != null) {
            setData(datas);
        }
    }

    @NonNull
    @Override
    public NewsListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_item, viewGroup, false);
        return new NewsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsListViewHolder viewHolder, int i) {
        super.onBindViewHolder(viewHolder, i);
        Glide.with(mContext).load(mData.get(i).getThumbnail_pic_s()).into(viewHolder.imgIcon);
        viewHolder.tvTitle.setText(mData.get(i).getTitle());
        viewHolder.tvFrom.setText(mData.get(i).getAuthor_name());
        viewHolder.tvTime.setText(mData.get(i).getDate());
    }

    static class NewsListViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgIcon;
        public TextView tvTitle;
        public TextView tvFrom;
        public TextView tvTime;

        public NewsListViewHolder(@NonNull View itemView) {
            super(itemView);

            imgIcon = itemView.findViewById(R.id.image);
            tvTitle = itemView.findViewById(R.id.title);
            tvFrom = itemView.findViewById(R.id.from);
            tvTime = itemView.findViewById(R.id.time);
        }
    }
}
