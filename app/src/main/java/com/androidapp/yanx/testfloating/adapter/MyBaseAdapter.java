package com.androidapp.yanx.testfloating.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * com.androidapp.yanx.testfloating.adapter
 * Created by yanx on 12/5/15 9:28 PM.
 * Description ${TODO}
 */
public class MyBaseAdapter extends RecyclerView.Adapter {

    protected OnItemClickListener onItemClickListener ;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void OnItemClick(View view);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
