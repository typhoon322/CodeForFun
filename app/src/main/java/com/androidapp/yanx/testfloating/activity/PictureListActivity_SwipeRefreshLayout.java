package com.androidapp.yanx.testfloating.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.AutoTransition;
import android.transition.Scene;
import android.transition.Transition;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Toast;

import com.androidapp.yanx.testfloating.R;
import com.androidapp.yanx.testfloating.adapter.MyBaseAdapter;
import com.androidapp.yanx.testfloating.adapter.PictureListAdapter;
import com.androidapp.yanx.testfloating.utils.DeviceUtil;
import com.androidapp.yanx.testfloating.widget.SpacesItemDecorator;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;

/**
 * com.androidapp.yanx.testfloating
 * Created by yanx on 12/5/15 6:55 PM.
 * Description ${TODO}
 */
public class PictureListActivity_SwipeRefreshLayout extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    Toolbar toolBar;

    SwipeRefreshLayout mSwipeRefreshLayout;

    RecyclerView recyclerView;

    PictureListAdapter adapter;

    ArrayList<String> urls = new ArrayList<>();

    Scene mScene1;

    Transition mTransition;

    LinearLayoutManager mLayoutManager;


    private void addPicture() {
        urls.add(2, "http://img1.ph.126.net/6AIC3r51awuw56hxJW04ww==/6630176061770622457.jpg");
        adapter.notifyItemInserted(2);
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

    int lastVisibleItemPos;

    boolean isLoading;

    String header = "header";
    String footer = "footer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.acitivity_picture_list_swipe_refresh);

        urls.add(header);

        toolBar = (Toolbar) findViewById(R.id.toolbar);
        toolBar.setTitle("Picture List Demo");
        setSupportActionBar(toolBar);

        mScene1 = new Scene((ViewGroup) findViewById(R.id.root_view));

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light, android.R.color.holo_orange_light);
        mSwipeRefreshLayout.setDistanceToTriggerSync(DeviceUtil.dp2px(24));
        mSwipeRefreshLayout.setOnRefreshListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new SpacesItemDecorator(20));
        adapter = new PictureListAdapter(this, urls);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (!isLoading && newState == RecyclerView.SCROLL_STATE_IDLE && !mSwipeRefreshLayout.isRefreshing() && adapter.getItemCount() == lastVisibleItemPos + 1) {
                    isLoading = true;
                    mHandler.sendEmptyMessageDelayed(2, 2000);
                    Toast.makeText(getApplicationContext(), "onLoadMore", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItemPos = mLayoutManager.findLastVisibleItemPosition();
            }
        });

        adapter.setOnItemClickListener(new MyBaseAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view) {

                mTransition = new AutoTransition();
                mTransition.setDuration(500);
                mTransition.setInterpolator(new AccelerateDecelerateInterpolator());

                Intent intent = new Intent(getApplicationContext(), BigPictureActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("url", view.getTag().toString());
                intent.putExtras(bundle);
//                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(PictureListActivity.this).toBundle());
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(PictureListActivity_SwipeRefreshLayout.this, view.findViewById(R.id.iv_picture), "picture").toBundle());
            }
        });


        refreshData();
    }

    private void loadMoreData() {
//        urls.add("http://img1.ph.126.net/bfrcm3gkDicrMrcGEp32zA==/6631426206491702935.jpg");
//        urls.add("http://img1.ph.126.net/w-N_wTsFv0Day7Js62_Srg==/6631311857282417410.jpg");
//        urls.add("http://img1.ph.126.net/MZEzh9jvu3Qk2GcuJcUWig==/6631212901236021232.jpg");
//        urls.add("http://img0.ph.126.net/kcQ2Q4jI9IE5yHcCV1LedQ==/6631330548980190414.jpg");
//        urls.add("http://img1.ph.126.net/S2PGjfW0hiLlSY5TKqv8Ew==/6630534502561274767.jpg");
//        urls.add("http://img2.ph.126.net/UNSmFYJJBoagsTDPrxpRDw==/6630629060562032393.jpg");
//        urls.add("http://img1.ph.126.net/6AIC3r51awuw56hxJW04ww==/6630176061770622457.jpg");
        currentIndex++;
        if (currentIndex >= 3) {
            urls.remove(footer);
            adapter.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(), "已加载完成全部数据", Toast.LENGTH_SHORT).show();
            isLoading = false;
            return;
        }
        urls.remove(footer);
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

        urls.add(footer);
        isLoading = false;
        currentIndex++;
        if (currentIndex >= 3) {
            urls.remove(footer);
        }
        adapter.notifyDataSetChanged();
    }

    private void refreshData() {
        urls.clear();
        urls.add(0, header);

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

        urls.remove(footer);
        urls.add(footer);
        adapter.notifyDataSetChanged();
        mSwipeRefreshLayout.setRefreshing(false);
        currentIndex = 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(1, 1, 1, "Add Picture");

        return super.onCreateOptionsMenu(menu);
    }

    int currentIndex;

    android.os.Handler mHandler = new android.os.Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    refreshData();
                    break;
                case 2:
                    loadMoreData();
                    break;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    public void onRefresh() {
        Toast.makeText(this, "onRefresh", Toast.LENGTH_SHORT).show();
        mHandler.sendEmptyMessageDelayed(1, 3000);
    }
}
