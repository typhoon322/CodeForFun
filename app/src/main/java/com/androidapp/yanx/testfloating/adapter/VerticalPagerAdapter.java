package com.androidapp.yanx.testfloating.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.androidapp.yanx.testfloating.verticalpager.PagerAdapter;

import java.util.List;

/**
 * ****************************************************************************
 * Copyright (C) 2014-2015 junte Corporation. All rights reserved
 * File Name	: ${FILE_NAME}.java
 * Description	: ${TODO}
 * Author		: xieyan@tuandai.com
 * Version		: v1.0
 * Date			: 2016/1/23 10:15
 * History		:
 * Date			Version			Modify
 * ****************************************************************************
 **/
public class VerticalPagerAdapter extends PagerAdapter {

    private List<View> mViewList;

    public VerticalPagerAdapter(List<View> viewList) {
        mViewList = viewList;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        container.removeView(mViewList.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mViewList.get(position));
        return mViewList.get(position);
    }

    @Override
    public int getCount() {
        return mViewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == object;
    }
}
