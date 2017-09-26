package com.example.administrator.bannerdemo;

import android.view.View;

import com.example.administrator.bannerdemo.views.BannerLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/25.
 */

public class BannerLayoutActivity extends BaseActivity {
    private BannerLayout banner_layout;//头布局中的bannner
    private List<String> mDatas = new ArrayList<String>();
    private List<Integer> mBanberDatas;
    @Override
    protected void initVariables() {
        for (int i = 0; i < 10; i++) {
            mDatas.add("item" + i);
        }
        mBanberDatas = new ArrayList<Integer>();
        mBanberDatas.add(0, R.drawable.banner1);
        mBanberDatas.add(1, R.drawable.banner3);
        mBanberDatas.add(2, R.drawable.banner4);
    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_bannerlayout);
        banner_layout = (BannerLayout) findViewById(R.id.banner_layout);
        banner_layout.setViewRes(mBanberDatas);
        //加载网络数据
        //banner_layout.setViewUrls();

    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
        banner_layout.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //banner item被电击
            }
        });
        banner_layout.setOnBannerItemPosionListener(new BannerLayout.OnBannerItemPosionListener() {
            @Override
            public void onItemPosition(int position) {
                //返回当前item的position
            }
        });


    }

    @Override
    protected void loadData() {

    }
}
