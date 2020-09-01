package com.example.commonlib.adapter;

import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @Description: BaseRecyclerViewAdapter
 * @Author: Li Xiuliang
 * @CreateDate: 2020/8/14 17:06
 * @Version: 1.0
 */
public class BaseRecyclerViewAdapter<T, VH extends RecyclerView.ViewHolder> extends  RecyclerView.Adapter<VH>{
    protected List<T> mData = new ArrayList<>();

    protected OnItemClickListener mOnItemClickListener;

    public void setData(List<T> data) {
        mData = data;
        notifyDataSetChanged();
    }

    public void setmOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull VH viewHolder, final int position) {
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(v, position);
                }
            }
        });

        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemLongClick(v, position);
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
