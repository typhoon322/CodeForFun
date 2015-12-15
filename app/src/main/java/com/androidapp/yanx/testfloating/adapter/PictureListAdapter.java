package com.androidapp.yanx.testfloating.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidapp.yanx.testfloating.R;
import com.androidapp.yanx.testfloating.utils.DeviceUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

/**
 * com.androidapp.yanx.testfloating.adapter
 * Created by yanx on 12/5/15 9:12 PM.
 * Description ${TODO}
 */
public class PictureListAdapter extends MyBaseAdapter {

    RelativeLayout.LayoutParams layoutParams;
    private ArrayList<String> urls;
    private LayoutInflater inflater;
    private Context mContext;

    public PictureListAdapter(Context context, ArrayList<String> list) {
        mContext = context;
        setUrls(list);
        inflater = LayoutInflater.from(context);
        layoutParams = new RelativeLayout.LayoutParams(DeviceUtil.getScreenSize(mContext)[0] / 2, DeviceUtil.getScreenSize(mContext)[0] / 2);
    }

    private void setUrls(ArrayList<String> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        urls = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = inflater.inflate(R.layout.layout_item_picture, parent, false);
        Holder holder = new Holder(rootView);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String url = urls.get(position);
        ((Holder) holder).ivPicture.setImageURI(Uri.parse(url));
        holder.itemView.setTag(url);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.OnItemClick(v);
                }
            }
        });
        ((Holder) holder).tvTitle.setText("This is picture "+(position+1));
    }

    @Override
    public int getItemCount() {
        return urls.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        SimpleDraweeView ivPicture;
        TextView tvTitle;

        public Holder(View itemView) {
            super(itemView);
            ivPicture = (SimpleDraweeView) itemView.findViewById(R.id.iv_picture);
            ivPicture.setLayoutParams(layoutParams);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
