package com.androidapp.yanx.testfloating.utils;

import android.content.Context;
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
}
