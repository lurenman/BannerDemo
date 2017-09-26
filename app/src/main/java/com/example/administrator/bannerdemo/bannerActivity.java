package com.example.administrator.bannerdemo;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/9/25.
 * 参考https://github.com/youth5201314/banner
 */

public class bannerActivity extends BaseActivity {
    private TextView tv_bannerSample;
    private TextView tv_IndicatorPosition;
    private TextView tv_BannerStyle;
    private TextView tv_CustomBanner;
    private TextView tv_BannerAnimation;

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_banner);
        tv_bannerSample = (TextView) findViewById(R.id.tv_bannerSample);
        tv_IndicatorPosition = (TextView) findViewById(R.id.tv_IndicatorPosition);
        tv_BannerStyle = (TextView) findViewById(R.id.tv_BannerStyle);
        tv_CustomBanner = (TextView) findViewById(R.id.tv_CustomBanner);
        tv_BannerAnimation = (TextView) findViewById(R.id.tv_BannerAnimation);

    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
        tv_bannerSample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bannerActivity.this,bannerSampleActivity.class);
                startActivity(intent);
            }
        });
        tv_IndicatorPosition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bannerActivity.this,IndicatorPositionActivity.class);
                startActivity(intent);
            }
        });
        tv_BannerStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bannerActivity.this,BannerStyleActivity.class);
                startActivity(intent);
            }
        });
        tv_CustomBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bannerActivity.this,CustomBannerActivity.class);
                startActivity(intent);
            }
        });
        tv_BannerAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bannerActivity.this,BannerAnimationActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
