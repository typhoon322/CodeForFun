package com.androidapp.yanx.testfloating.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.androidapp.yanx.testfloating.entity.Blog;

/**
 * ****************************************************************************
 * Copyright (C) 2014-2015 junte Corporation. All rights reserved
 * File Name	: ${FILE_NAME}.java
 * Description	: ${TODO}
 * Author		: xieyan@tuandai.com
 * Version		: v1.0
 * Date			: 2016/3/23 14:48
 * History		:
 * Date			Version			Modify
 * ****************************************************************************
 **/
public abstract class MomentBaseHolder extends RecyclerView.ViewHolder {
    public MomentBaseHolder(View itemView) {
        super(itemView);
    }

    abstract void update(Blog blog);
}
