package com.example.administrator.bannerdemo;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.example.administrator.bannerdemo.loader.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/9/26.
 */

public class BannerStyleActivity extends BaseActivity implements AdapterView.OnItemSelectedListener {
    private Banner banner;
    private Spinner spinnerStyle;
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
        setContentView(R.layout.activity_banner_style);
        banner = (Banner) findViewById(R.id.banner);
        spinnerStyle = (Spinner) findViewById(R.id.spinnerStyle);
        spinnerStyle.setOnItemSelectedListener(this);
        //默认是CIRCLE_INDICATOR
        banner.setImages(mArrayUrls)
                .setBannerTitles(mArrayTitles)
                .setBannerStyle(BannerConfig.NOT_INDICATOR)
                .setImageLoader(new GlideImageLoader())
                .start();

    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                banner.updateBannerStyle(BannerConfig.NOT_INDICATOR);
                break;
            case 1:
                banner.updateBannerStyle(BannerConfig.CIRCLE_INDICATOR);
                break;
            case 2:
                banner.updateBannerStyle(BannerConfig.NUM_INDICATOR);
                break;
            case 3:
                banner.updateBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
                break;
            case 4:
                banner.updateBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
                break;
            case 5:
                banner.updateBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
