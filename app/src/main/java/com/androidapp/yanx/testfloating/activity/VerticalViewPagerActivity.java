package com.androidapp.yanx.testfloating.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.androidapp.yanx.testfloating.R;
import com.androidapp.yanx.testfloating.adapter.VerticalPagerAdapter;
import com.androidapp.yanx.testfloating.verticalpager.VerticalViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * ****************************************************************************
 * Copyright (C) 2014-2015 junte Corporation. All rights reserved
 * File Name	: ${FILE_NAME}.java
 * Description	: ${TODO}
 * Author		: xieyan@tuandai.com
 * Version		: v1.0
 * Date			: 2016/1/23 10:13
 * History		:
 * Date			Version			Modify
 * ****************************************************************************
 **/
public class VerticalViewPagerActivity extends Activity {

    private VerticalViewPager mVerticalViewPager;

    private VerticalPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_view_pager);
        init();
    }


    private void init() {
        mVerticalViewPager = (VerticalViewPager) findViewById(R.id.vertical_view_pager);
        List<View> viewList = new ArrayList<>();
        viewList.add(getLayoutInflater().inflate(R.layout.layout_page_1, null));
        viewList.add(getLayoutInflater().inflate(R.layout.layout_page_2, null));
        mAdapter = new VerticalPagerAdapter(viewList);
        mVerticalViewPager.setAdapter(mAdapter);
    }

}
