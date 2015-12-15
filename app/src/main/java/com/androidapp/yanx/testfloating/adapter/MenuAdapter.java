package com.androidapp.yanx.testfloating.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.androidapp.yanx.testfloating.R;
import com.androidapp.yanx.testfloating.entity.MenuListItemMdl;

import java.util.ArrayList;

/**
 * com.androidapp.yanx.testfloating.adapter
 * Created by yanx on 12/5/15 7:09 PM.
 * Description ${TODO}
 */
public class MenuAdapter extends MyBaseAdapter {

    private ArrayList<MenuListItemMdl> dataList;
    private LayoutInflater inflater;

    public MenuAdapter(Context context, ArrayList<MenuListItemMdl> list) {
        inflater = LayoutInflater.from(context);
        setDataList(list);
    }

    public void setDataList(ArrayList<MenuListItemMdl> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        dataList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = inflater.inflate(R.layout.layout_item_menu, parent, false);
        Holder holder = new Holder(rootView);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MenuListItemMdl menuItem = dataList.get(position);
        if (menuItem != null) {
            ((Holder) holder).tvName.setText(menuItem.displayName);
            ((Holder) holder).tvName.setTag(menuItem);

            ((Holder) holder).tvName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.OnItemClick(v);
                    }
                }
            });
        }
    }

    @Override
    public long getItemId(int position) {
        return dataList.get(position).hashCode();
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    class Holder extends RecyclerView.ViewHolder {
        public Button tvName;

        public Holder(View itemView) {
            super(itemView);
            tvName = (Button) itemView.findViewById(R.id.tvName);
        }
    }

}
