package testwave;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.androidapp.yanx.testfloating.R;

/**
 * ****************************************************************************
 * Copyright (C) 2014-2015 junte Corporation. All rights reserved
 * File Name	: ${FILE_NAME}.java
 * Description	: ${TODO}
 * Author		: xieyan@tuandai.com
 * Version		: v1.0
 * Date			: 2016/1/15 11:53
 * History		:
 * Date			Version			Modify
 * ****************************************************************************
 **/
public class CustomProgressView extends FrameLayout {
    public CustomProgressView(Context context) {
        super(context);
        initView();
    }

    public CustomProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public CustomProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private DynamicWave mDynamicWave;
    private TextView mTextView1;

    private TextView mTextView2;

    private void initView() {
        inflate(getContext(), R.layout.view_progress, this);
        mDynamicWave = (DynamicWave) findViewById(R.id.wave);
        mTextView1 = (TextView) findViewById(R.id.tv_1);
        mTextView2 = (TextView) findViewById(R.id.tv_2);
    }

    public void setContentText1(String text) {
        mTextView1.setText(text);
    }

    public void setContentText2(String text) {
        mTextView2.setText(text);
    }

    public void setContentTextColor1(int colorResId) {
        mTextView1.setTextColor(ContextCompat.getColor(getContext(), colorResId));
    }

    public void setContentTextColor2(int colorResId) {
        mTextView2.setTextColor(ContextCompat.getColor(getContext(), colorResId));
    }

    public void setContentTextSize1(int sizeInSp) {
        mTextView1.setTextSize(TypedValue.COMPLEX_UNIT_SP, sizeInSp);
    }

    public void setContentTextSize2(int sizeInSp) {
        mTextView1.setTextSize(TypedValue.COMPLEX_UNIT_SP, sizeInSp);
    }

    public void setProgressLevel(int progressLevel) {
        mDynamicWave.setLevel(progressLevel);
    }


}
