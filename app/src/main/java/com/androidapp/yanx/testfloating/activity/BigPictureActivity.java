package com.androidapp.yanx.testfloating.activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.androidapp.yanx.testfloating.R;
import com.androidapp.yanx.testfloating.utils.DeviceUtil;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by pc on 2015/12/6.
 */
public class BigPictureActivity extends Activity implements View.OnClickListener {

    private static final String TAG = "BigPictureActivity";

    SimpleDraweeView photoView;

//    PhotoViewAttacher mAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_big_picture_activity);

//        ExplosionField explosionField = new ExplosionField(this);

//        explosionField.addListener(findViewById(R.id.root_view));

        photoView = (SimpleDraweeView) findViewById(R.id.iv_picture);

        photoView.setOnClickListener(this);

        int[] screenSize = DeviceUtil.getScreenSize(this);

        ViewGroup.LayoutParams layoutParams = photoView.getLayoutParams();
        layoutParams.width = screenSize[0];
        layoutParams.height = screenSize[1];

//        mAttacher = new PhotoViewAttacher(photoView);

        String url = getIntent().getExtras().getString("url");
        if (null != url && !url.equals("")) {
            photoView.setImageURI(Uri.parse(url));
//            mAttacher.update();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAfterTransition();
    }

    @Override
    public void onClick(View view) {
        Log.i(TAG, "onClick: " + view);
        onBackPressed();
    }
}
