package com.androidapp.yanx.testfloating.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidapp.yanx.testfloating.R;
import com.androidapp.yanx.testfloating.entity.Blog;
import com.androidapp.yanx.testfloating.widget.InnerGridView;

import java.util.List;

/**
 * ****************************************************************************
 * Copyright (C) 2014-2015 junte Corporation. All rights reserved
 * File Name	: ${FILE_NAME}.java
 * Description	: ${TODO}
 * Author		: xieyan@tuandai.com
 * Version		: v1.0
 * Date			: 2016/3/23 10:09
 * History		:
 * Date			Version			Modify
 * ****************************************************************************
 **/
public class MomentAdapter extends MyBaseAdapter {
    private List<Blog> mDataList;

    private Context mContext;

    private LayoutInflater mInflater;

    public MomentAdapter(Context context, List<Blog> dataList) {
        mDataList = dataList;
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.layout_item_moment, parent, false);
        MomentHolder holder = new MomentHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Blog blog = mDataList.get(position);
        ((MomentHolder) holder).update(blog);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    class MomentHolder extends RecyclerView.ViewHolder {

        public MomentHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            igvImage = (InnerGridView) itemView.findViewById(R.id.grid_view);
            adapter = new MomentImageAdapter(mContext);
        }

        public void update(Blog blog) {
            if (blog == null) {
                return;
            }
            tvName.setText(blog.name);
            adapter.setData(blog.urls);
            igvImage.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }

        public TextView tvName;

        public InnerGridView igvImage;

        public MomentImageAdapter adapter;

    }
}
