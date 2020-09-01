package com.example.commonlib.adapter;

import android.view.View;

/**
 * @Description: OnItemClickListener
 * @Author: Li Xiuliang
 * @CreateDate: 2020/8/14 18:14
 * @Version: 1.0
 */
public interface OnItemClickListener {
    public void onItemClick(View v, int position);
    public void onItemLongClick(View v, int position);
}
