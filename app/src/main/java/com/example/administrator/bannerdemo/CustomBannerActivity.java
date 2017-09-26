package com.example.administrator.bannerdemo;

import com.example.administrator.bannerdemo.loader.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/9/26.
 */

public class CustomBannerActivity extends BaseActivity {
    private Banner banner1, banner2, banner3;
    private List mArrayUrls;
    private List mArrayTitles;

    @Override
    protected void initVariables() {
        String[] urls = getResources().getStringArray(R.array.url);
        List list = Arrays.asList(urls);
        mArrayUrls = new ArrayList(list);

        String[] tips = getResources().getStringArray(R.array.title);
        List list1 = Arrays.asList(tips);
        mArrayTitles = new ArrayList(list1);
    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_custom_banner);
        banner1 = (Banner) findViewById(R.id.banner1);
        banner2 = (Banner) findViewById(R.id.banner2);
        banner3 = (Banner) findViewById(R.id.banner3);

        banner1.setImages(mArrayUrls)
                .setImageLoader(new GlideImageLoader())
                .start();

        banner2.setImages(mArrayUrls)
                .setImageLoader(new GlideImageLoader())
                .start();

        banner3.setImages(mArrayUrls)
                .setBannerTitles(mArrayTitles)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                .setImageLoader(new GlideImageLoader())
                .start();
    }

    @Override
    protected void loadData() {

    }
}
