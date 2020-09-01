package com.example.home.ui.main;

import com.example.commonlib.mvp.BaseFragment;
import com.example.home.adapter.NewsListRvAdapter;
import com.example.home.bean.response.NewsItem;
import com.example.home.R;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NewsFragment extends BaseFragment<NewsPresenter> implements NewsContract.View {
    private RecyclerView mNewsListRV;
    private NewsListRvAdapter mNewsListAdapter;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initView() {
        mNewsListRV = getView().findViewById(R.id.news_list_rv);
        mNewsListRV.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mNewsListRV.setLayoutManager(mLayoutManager);
        mNewsListAdapter = new NewsListRvAdapter(getContext(), null);
        mNewsListRV.setAdapter(mNewsListAdapter);
    }

    @Override
    protected void initData() {
        mPresenter.getNews();
    }

    @Override
    protected NewsPresenter createPresenter() {
        return new NewsPresenter();
    }

    @Override
    public void showNews(final List<NewsItem> newsList) {
//        getActivity().runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
                mNewsListAdapter.setData(newsList);
//            }
//        });
    }

    @Override
    public void showError(String message) {
        showToast(message);
    }
}
