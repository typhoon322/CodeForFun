package com.androidapp.yanx.testfloating.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.androidapp.yanx.testfloating.R;
import com.androidapp.yanx.testfloating.adapter.MyBaseAdapter;
import com.androidapp.yanx.testfloating.adapter.PictureListAdapter;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * com.androidapp.yanx.testfloating
 * Created by yanx on 12/5/15 6:55 PM.
 * Description ${TODO}
 */
public class PictureListActivity extends SwipeBackActivity {

    RecyclerView recyclerView ;

    PictureListAdapter adapter ;

    ArrayList<String> urls = new ArrayList<>() ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.acitivity_picture_list);

        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapter = new PictureListAdapter(this,urls) ;
        recyclerView.setAdapter(adapter);

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

        adapter.notifyDataSetChanged();
        adapter.setOnItemClickListener(new MyBaseAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view) {
                Toast.makeText(getApplicationContext(),view.getTag().toString(),Toast.LENGTH_SHORT).show() ;
            }
        });
    }
}
