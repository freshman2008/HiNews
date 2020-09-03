package com.example.news.ui.main;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.commonlib.adapter.OnItemClickListener;
import com.example.commonlib.mvp.BaseFragment;
import com.example.commonlib.utils.ARouterConstants;
import com.example.news.adapter.NewsListRvAdapter;
import com.example.news.bean.response.NewsItem;
import com.example.news.R;
import com.example.provider.HelloService;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

@Route(path = ARouterConstants.HOME.NEWS_FRAGMENT)
public class NewsFragment extends BaseFragment<NewsPresenter> implements NewsContract.View {
    private RecyclerView mNewsListRV;
    private NewsListRvAdapter mNewsListAdapter;
    private LinearLayoutManager mLayoutManager;

//    @Autowired
//    HelloService helloService;

    @Override
    protected int getLayoutResId() {
        return R.layout.news_fragment_news;
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
        mNewsListAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
//                Toast.makeText(getContext(), "Item " + position + " is clicked.", Toast.LENGTH_SHORT).show();
                ARouter.getInstance().build(ARouterConstants.MINE.MINE_LONGIN_ACTIVITY).navigation();
            }

            @Override
            public void onItemLongClick(View v, int position) {
//                Toast.makeText(getContext(), "Item " + position + " is long clicked.", Toast.LENGTH_SHORT).show();
                HelloService helloService = (HelloService) ARouter.getInstance().build(ARouterConstants.HOME.SERVICE_HELLO).navigation();
                String result = helloService.sayHello("Edward");
            }
        });
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
