package com.androidapp.yanx.testfloating.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.androidapp.yanx.testfloating.R;
import com.androidapp.yanx.testfloating.adapter.MomentAdapter;
import com.androidapp.yanx.testfloating.entity.Blog;
import com.androidapp.yanx.testfloating.widget.SpacesItemDecorator;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ****************************************************************************
 * Copyright (C) 2014-2015 junte Corporation. All rights reserved
 * File Name	: ${FILE_NAME}.java
 * Description	: ${TODO}
 * Author		: xieyan@tuandai.com
 * Version		: v1.0
 * Date			: 2016/3/23 9:42
 * History		:
 * Date			Version			Modify
 * ****************************************************************************
 **/
public class MomentActivity extends AppCompatActivity {
    Toolbar toolBar;

    RecyclerView recyclerView;

    MomentAdapter adapter;

    List<Blog> mBlogs = new ArrayList<>();

    private void addPicture() {
//        urls.add(2, "http://img1.ph.126.net/6AIC3r51awuw56hxJW04ww==/6630176061770622457.jpg");
//        adapter.notifyItemInserted(2);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                addPicture();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    List<String> urls;

    private void initUrls() {
        urls = new ArrayList<>();


        urls.add("http://img1.ph.126.net/bfrcm3gkDicrMrcGEp32zA==/6631426206491702935.jpg");
        urls.add("http://img1.ph.126.net/w-N_wTsFv0Day7Js62_Srg==/6631311857282417410.jpg");
        urls.add("http://img1.ph.126.net/MZEzh9jvu3Qk2GcuJcUWig==/6631212901236021232.jpg");
        urls.add("http://img0.ph.126.net/kcQ2Q4jI9IE5yHcCV1LedQ==/6631330548980190414.jpg");
        urls.add("http://img1.ph.126.net/S2PGjfW0hiLlSY5TKqv8Ew==/6630534502561274767.jpg");
        urls.add("http://img2.ph.126.net/UNSmFYJJBoagsTDPrxpRDw==/6630629060562032393.jpg");
        urls.add("http://img1.ph.126.net/6AIC3r51awuw56hxJW04ww==/6630176061770622457.jpg");
        urls.add("http://img0.ph.126.net/6n2RIbNbTIon5SJDGUBbyQ==/6630883047748045659.jpg");
        urls.add("http://img2.ph.126.net/ESxq9veyHpzybY-MwCK9PA==/6630577383515523215.jpg");
        urls.add("http://img0.ph.126.net/Dbg-yWgDtRvE-kf2YdGTmQ==/6631343743119733731.jpg");
        urls.add("http://img0.ph.126.net/JINJAaIk68arARpnvCnxEg==/6631381126515079089.jpg");
        urls.add("http://img0.ph.126.net/GJWFp0SPr431ecsOz70cSA==/6631311857282527350.jpg");
        urls.add("http://img1.ph.126.net/EH2moaw7a_mkGJpu0YeSLg==/6631249185119727685.jpg");
        urls.add("http://img0.ph.126.net/SSaBuGA0IXxEayixOVOvlg==/6631311857282586957.jpg");
        urls.add("http://img2.ph.126.net/pJBpoERMwsEC7XBTZVNU0g==/2218867241511048467.jpg");
        urls.add("http://img2.ph.126.net/uSN9c57GPhxKxmqzCXWknQ==/6619366762956129359.jpg");
        urls.add("http://img2.ph.126.net/_8k9BZUVdto9Fq9qP0Ei8Q==/3843540807084037031.jpg");
        urls.add("http://img2.ph.126.net/eubd-Z2wjCwiaUMdf_E3sw==/1040894463893497709.jpg");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.acitivity_picture_list);

        toolBar = (Toolbar) findViewById(R.id.toolbar);
        toolBar.setTitle("Picture List Demo");
        setSupportActionBar(toolBar);

        initUrls();

        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new SpacesItemDecorator(20));
        adapter = new MomentAdapter(this, mBlogs);
        recyclerView.setAdapter(adapter);

        mBlogs.add(new Blog("Lisa", getUrl(1), ""));
        mBlogs.add(new Blog("Peter", getUrl(2), ""));
        mBlogs.add(new Blog("Andrew", getUrl(3), ""));
        mBlogs.add(new Blog("Maya", getUrl(4), ""));
        mBlogs.add(new Blog("Adel", getUrl(5), ""));
        mBlogs.add(new Blog("Hunter", getUrl(6), ""));
        mBlogs.add(new Blog("Jim", getUrl(7), ""));
        mBlogs.add(new Blog("Jason", getUrl(8), ""));
        mBlogs.add(new Blog("Lily", getUrl(9), ""));
        mBlogs.add(new Blog("Leo", getUrl(7), ""));
        mBlogs.add(new Blog("Mann", getUrl(6), ""));
        mBlogs.add(new Blog("Water", getUrl(3), ""));
        mBlogs.add(new Blog("Bobbi", getUrl(2), ""));
        mBlogs.add(new Blog("Ken", getUrl(4), ""));
        mBlogs.add(new Blog("Alice", getUrl(5), ""));
        mBlogs.add(new Blog("Milly", getUrl(7), ""));
        mBlogs.add(new Blog("Mel", getUrl(6), ""));
        mBlogs.add(new Blog("Candy", getUrl(5), ""));
        mBlogs.add(new Blog("Cindy", getUrl(2), ""));
        mBlogs.add(new Blog("Tress", getUrl(3), ""));
        mBlogs.add(new Blog("Dim", getUrl(4), ""));
        mBlogs.add(new Blog("Andy", getUrl(8), ""));
        mBlogs.add(new Blog("Billy", getUrl(7), ""));
        mBlogs.add(new Blog("Focus", getUrl(8), ""));
        mBlogs.add(new Blog("Vincent", getUrl(9), ""));
        mBlogs.add(new Blog("Yan", getUrl(8), ""));
        mBlogs.add(new Blog("Cuby", getUrl(6), ""));
        mBlogs.add(new Blog("Winter", getUrl(7), ""));
        mBlogs.add(new Blog("Summer", getUrl(5), ""));
        mBlogs.add(new Blog("Fall", getUrl(4), ""));
        mBlogs.add(new Blog("October", getUrl(3), ""));
        mBlogs.add(new Blog("November", getUrl(2), ""));
        mBlogs.add(new Blog("December", getUrl(1), ""));
        mBlogs.add(new Blog("January", getUrl(2), ""));
        mBlogs.add(new Blog("February", getUrl(9), ""));

        mBlogs.add(new Blog("Lisa", getUrl(1), ""));
        mBlogs.add(new Blog("Peter", getUrl(2), ""));
        mBlogs.add(new Blog("Andrew", getUrl(3), ""));
        mBlogs.add(new Blog("Maya", getUrl(4), ""));
        mBlogs.add(new Blog("Adel", getUrl(5), ""));
        mBlogs.add(new Blog("Hunter", getUrl(6), ""));
        mBlogs.add(new Blog("Jim", getUrl(7), ""));
        mBlogs.add(new Blog("Jason", getUrl(8), ""));
        mBlogs.add(new Blog("Lily", getUrl(9), ""));
        mBlogs.add(new Blog("Leo", getUrl(7), ""));
        mBlogs.add(new Blog("Mann", getUrl(6), ""));
        mBlogs.add(new Blog("Water", getUrl(3), ""));
        mBlogs.add(new Blog("Bobbi", getUrl(2), ""));
        mBlogs.add(new Blog("Ken", getUrl(4), ""));
        mBlogs.add(new Blog("Alice", getUrl(5), ""));
        mBlogs.add(new Blog("Milly", getUrl(7), ""));
        mBlogs.add(new Blog("Mel", getUrl(6), ""));
        mBlogs.add(new Blog("Candy", getUrl(5), ""));
        mBlogs.add(new Blog("Cindy", getUrl(2), ""));
        mBlogs.add(new Blog("Tress", getUrl(3), ""));
        mBlogs.add(new Blog("Dim", getUrl(4), ""));
        mBlogs.add(new Blog("Andy", getUrl(8), ""));
        mBlogs.add(new Blog("Billy", getUrl(7), ""));
        mBlogs.add(new Blog("Focus", getUrl(8), ""));
        mBlogs.add(new Blog("Vincent", getUrl(9), ""));
        mBlogs.add(new Blog("Yan", getUrl(8), ""));
        mBlogs.add(new Blog("Cuby", getUrl(6), ""));
        mBlogs.add(new Blog("Winter", getUrl(7), ""));
        mBlogs.add(new Blog("Summer", getUrl(5), ""));
        mBlogs.add(new Blog("Fall", getUrl(4), ""));
        mBlogs.add(new Blog("October", getUrl(3), ""));
        mBlogs.add(new Blog("November", getUrl(2), ""));
        mBlogs.add(new Blog("December", getUrl(1), ""));
        mBlogs.add(new Blog("January", getUrl(2), ""));
        mBlogs.add(new Blog("February", getUrl(9), ""));

        adapter.notifyDataSetChanged();

    }

    private List<String> getUrl(int num) {
        List<String> list = new ArrayList<>();
        Random random = new Random(urls.size());
        for (int i = 0; i < num; i++) {
            list.add(urls.get(random.nextInt(18)));
        }
        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

//        menu.add(1, 1, 1, "Add Picture");

        return super.onCreateOptionsMenu(menu);
    }
}
