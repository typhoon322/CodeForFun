package com.androidapp.yanx.testfloating.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.androidapp.yanx.testfloating.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * ****************************************************************************
 * Copyright (C) 2014-2015 junte Corporation. All rights reserved
 * File Name	: ${FILE_NAME}.java
 * Description	: ${TODO}
 * Author		: xieyan@tuandai.com
 * Version		: v1.0
 * Date			: 2016/3/23 10:25
 * History		:
 * Date			Version			Modify
 * ****************************************************************************
 **/
public class MomentImageAdapter extends BaseAdapter {

    private List<String> mUrls;

    private Context mContext;

    private LayoutInflater mInflater;

    public MomentImageAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    public MomentImageAdapter(List<String> urls, Context context) {
        this(context);
        mUrls = urls;
    }

    public void setData(List<String> urls) {
        if (urls == null) {
            urls = new ArrayList<>();
        }
        mUrls = urls;
    }

    @Override
    public int getCount() {
        return mUrls.size();
    }

    @Override
    public String getItem(int i) {
        return mUrls.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = mInflater.inflate(R.layout.layout_item_grid, viewGroup, false);
        }
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view;
        simpleDraweeView.setImageURI(Uri.parse(mUrls.get(i)));
        return view;
    }
}
