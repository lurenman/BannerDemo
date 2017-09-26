package com.example.administrator.bannerdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_BannerLayout;
    private TextView tv_banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initEvents();
    }

    private void initViews() {
        tv_BannerLayout = (TextView) findViewById(R.id.tv_BannerLayout);
        tv_banner = (TextView) findViewById(R.id.tv_banner);
    }

    private void initEvents() {
        tv_BannerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BannerLayoutActivity.class);
                startActivity(intent);
            }
        });
        tv_banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, bannerActivity.class);
                startActivity(intent);
            }
        });
    }


}
