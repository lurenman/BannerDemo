package com.example.administrator.bannerdemo;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.administrator.bannerdemo.loader.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/9/26.
 */

public class IndicatorPositionActivity extends BaseActivity{
    private Banner mBanner;
    private Spinner mSpinnerPosition;

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_indicator_position);
        mBanner = (Banner) findViewById(R.id.banner);
        mSpinnerPosition= (Spinner) findViewById(R.id.spinnerPosition);
       // mSpinnerPosition.setOnItemClickListener(this);//这个方法不能用
        String[] urls = getResources().getStringArray(R.array.url4);
        List list = Arrays.asList(urls);
        List arrayList = new ArrayList(list);
        mBanner.setImages(arrayList)
                .setImageLoader(new GlideImageLoader())
                //.setOnBannerListener(this)
                .start();
    }
    @Override
    protected void initEnvent() {
        super.initEnvent();

        mSpinnerPosition.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        mBanner.setIndicatorGravity(BannerConfig.LEFT);
                        break;
                    case 1:
                        mBanner.setIndicatorGravity(BannerConfig.CENTER);
                        break;
                    case 2:
                        mBanner.setIndicatorGravity(BannerConfig.RIGHT);
                        break;
                }
                //海里调用这个才管用
                mBanner.start();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
      mBanner.setOnBannerListener(new OnBannerListener() {
          @Override
          public void OnBannerClick(int position) {
              Toast.makeText(getApplicationContext(),"你点击了："+position,Toast.LENGTH_SHORT).show();
          }
      });
    }

    @Override
    protected void loadData() {

    }

}
