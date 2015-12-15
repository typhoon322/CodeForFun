package com.androidapp.yanx.testfloating.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Created by pc on 2015/12/6.
 */
public class DeviceUtil {

    public static int[] getScreenSize(Context context) {
        if (context == null) {
            return new int[]{0, 0};
        }
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return new int[]{metrics.widthPixels, metrics.heightPixels};
    }

    /**
     * 密度
     */
    public static final float DENSITY = Resources.getSystem().getDisplayMetrics().density;

    public static int dp2px(int dp) {
        return Math.round(dp * DENSITY);
    }
}
