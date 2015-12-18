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
        layoutParams = new RelativeLayout.LayoutParams((int) (DeviceUtil.getScreenSize(mContext)[0] * 0.9), DeviceUtil.getScreenSize(mContext)[0] / 2);
        layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
    }

    private void setUrls(ArrayList<String> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        urls = list;
    }

    final static int ITEM_HEADER = 1;
    final static int ITEM_NORMAL = 0;
    final static int ITEM_FOOTER = 2;

    @Override
    public int getItemViewType(int position) {
        if ("header".equals(urls.get(position))) {
            return ITEM_HEADER;
        } else if ("footer".equals(urls.get(position))) {
            return ITEM_FOOTER;
        } else {
            return ITEM_NORMAL;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case ITEM_HEADER:
                return new HeaderHolder(inflater.inflate(R.layout.header_layout, parent, false));
            case ITEM_NORMAL:
                return new ItemHolder(inflater.inflate(R.layout.layout_item_picture, parent, false));
            case ITEM_FOOTER:
                return new FooterHolder(inflater.inflate(R.layout.footer_layout, parent, false));
            default:
                throw new RuntimeException("No type matches!!");
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemHolder) {
            String url = urls.get(position);
            ((ItemHolder) holder).ivPicture.setImageURI(Uri.parse(url));
            holder.itemView.setTag(url);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.OnItemClick(v);
                    }
                }
            });
            ((ItemHolder) holder).tvTitle.setText("This is picture " + (position + 1));
        } else if (holder instanceof HeaderHolder) {
            ((HeaderHolder) holder).tvTitle.setText("This is HEADER");
        } else if (holder instanceof FooterHolder) {
            ((FooterHolder) holder).tvTitle.setText("正在努力加载...");
        }
    }

    @Override
    public int getItemCount() {
        return urls.size();
    }

    class ItemHolder extends RecyclerView.ViewHolder {

        SimpleDraweeView ivPicture;
        TextView tvTitle;

        public ItemHolder(View itemView) {
            super(itemView);
            ivPicture = (SimpleDraweeView) itemView.findViewById(R.id.iv_picture);
            ivPicture.setLayoutParams(layoutParams);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    class HeaderHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;

        public HeaderHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_header);
        }
    }

    class FooterHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;

        public FooterHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_footer);
        }
    }
}
