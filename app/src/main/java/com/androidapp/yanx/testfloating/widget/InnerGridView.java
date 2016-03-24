package com.androidapp.yanx.testfloating.widget;

import android.widget.GridView;

/**
 * ****************************************************************************
 * Copyright (C) 2014-2015 junte Corporation. All rights reserved
 * File Name	: ${FILE_NAME}.java
 * Description	: ${TODO}
 * Author		: xieyan@tuandai.com
 * Version		: v1.0
 * Date			: 2016/3/23 9:55
 * History		:
 * Date			Version			Modify
 * ****************************************************************************
 **/
public class InnerGridView extends GridView {
    public InnerGridView(android.content.Context context, android.util.AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 设置不滚动
     */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);

    }

}
