package com.androidapp.yanx.testfloating.entity;

import android.app.Activity;

/**
 * com.androidapp.yanx.testfloating.entity
 * Created by yanx on 12/5/15 7:04 PM.
 * Description ${TODO}
 */
public class MenuListItemMdl {
    public Class<? extends Activity> activity;
    public String displayName;

    public MenuListItemMdl() {
    }

    public MenuListItemMdl(Class<? extends Activity> activity, String displayName) {
        this.activity = activity;
        this.displayName = displayName;
    }
}
