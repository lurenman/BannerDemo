package com.example.administrator.bannerdemo;

import android.content.Context;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.bannerdemo.adapter.ListViewAdapter;
import com.example.administrator.bannerdemo.loader.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/9/26.
 */

public class bannerSampleActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, OnBannerListener {
    private SwipeRefreshLayout sl_swipe;
    private ListView lv_list;
    private Banner mBanner;
    private ListViewAdapter mListViewAdapter;
    private List<String> mDatas = new ArrayList<String>();

    @Override
    protected void initVariables() {
        for (int i = 0; i < 10; i++) {
            mDatas.add("item" + i);
        }
    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_banner_sample);
        sl_swipe = (SwipeRefreshLayout) findViewById(R.id.sl_swipe);
        lv_list = (ListView) findViewById(R.id.lv_list);
        sl_swipe.setOnRefreshListener(this);
        View header = View.inflate(getApplicationContext(), R.layout.header, null);
        mBanner= (Banner) header.findViewById(R.id.banner);
        //不懂为什么必须这么设置
        mBanner.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dip2px(getApplicationContext(),240)));
        lv_list.addHeaderView(mBanner);
        if (null != mDatas && !mDatas.isEmpty())
            mListViewAdapter = new ListViewAdapter(getApplicationContext(), mDatas);
        lv_list.setAdapter(mListViewAdapter);
    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
        //简单使用
        String[] urls = getResources().getStringArray(R.array.url4);
        List list = Arrays.asList(urls);
        List arrayList = new ArrayList(list);
        mBanner.setImages(arrayList)
                .setImageLoader(new GlideImageLoader())
                .setOnBannerListener(this)
                .start();
    }

    @Override
    protected void loadData() {

    }
    //如果你需要考虑更好的体验，可以这么操作
    @Override
    protected void onStart() {
        super.onStart();
        //开始轮播
        mBanner.startAutoPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //结束轮播
        mBanner.stopAutoPlay();
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //这有个更新的操作
               // banner.update(arrayList);
             sl_swipe.setRefreshing(false);
            }
        }, 2000);
    }

    @Override
    public void OnBannerClick(int position) {
        Toast.makeText(getApplicationContext(),"你点击了："+position,Toast.LENGTH_SHORT).show();
    }
    /**
     * 根据手机的分辨率从dip 的单位 转成为 px(像素)
     */
    public int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
