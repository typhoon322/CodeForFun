package testwave;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.androidapp.yanx.testfloating.R;

/**
 * ****************************************************************************
 * Copyright (C) 2014-2015 junte Corporation. All rights reserved
 * File Name	: ${FILE_NAME}.java
 * Description	: ${TODO}
 * Author		: xieyan@tuandai.com
 * Version		: v1.0
 * Date			: 2016/1/15 10:11
 * History		:
 * Date			Version			Modify
 * ****************************************************************************
 **/
public class WaveActivity extends Activity implements View.OnClickListener {

    private CustomProgressView myProgressView;

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wave);

        myProgressView = (CustomProgressView) findViewById(R.id.porter);
        mButton = (Button) findViewById(R.id.btn_add);
        mButton.setOnClickListener(this);

        myProgressView.setProgressLevel(5);
    }

    private int progressLevel = 5;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                if (progressLevel > 10) {
                    progressLevel = 0;
                }
                progressLevel += 1;
                myProgressView.setProgressLevel(progressLevel);
                break;
        }
    }
}
