package com.androidapp.yanx.testfloating.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidapp.yanx.testfloating.R;
import com.androidapp.yanx.testfloating.entity.Blog;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * ****************************************************************************
 * Copyright (C) 2014-2015 junte Corporation. All rights reserved
 * File Name	: ${FILE_NAME}.java
 * Description	: ${TODO}
 * Author		: xieyan@tuandai.com
 * Version		: v1.0
 * Date			: 2016/3/23 10:09
 * History		:
 * Date			Version			Modify
 * ****************************************************************************
 **/
public class MomentAdapterType extends MyBaseAdapter {
    private List<Blog> mDataList;

    private Context mContext;

    private LayoutInflater mInflater;

    public MomentAdapterType(Context context, List<Blog> dataList) {
        mDataList = dataList;
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case 1:
                itemView = mInflater.inflate(R.layout.layout_item_moment_num_1, parent, false);
                holder = new MomentHolder1(itemView);
                break;
            case 2:
                itemView = mInflater.inflate(R.layout.layout_item_moment_num_2, parent, false);
                holder = new MomentHolder2(itemView);
                break;
            case 3:
                itemView = mInflater.inflate(R.layout.layout_item_moment_num_3, parent, false);
                holder = new MomentHolder3(itemView);
                break;
            case 4:
                itemView = mInflater.inflate(R.layout.layout_item_moment_num_4, parent, false);
                holder = new MomentHolder4(itemView);
                break;
            case 5:
                itemView = mInflater.inflate(R.layout.layout_item_moment_num_5, parent, false);
                holder = new MomentHolder5(itemView);
                break;
            case 6:
                itemView = mInflater.inflate(R.layout.layout_item_moment_num_6, parent, false);
                holder = new MomentHolder6(itemView);
                break;
            case 7:
                itemView = mInflater.inflate(R.layout.layout_item_moment_num_7, parent, false);
                holder = new MomentHolder7(itemView);
                break;
            case 8:
                itemView = mInflater.inflate(R.layout.layout_item_moment_num_8, parent, false);
                holder = new MomentHolder8(itemView);
                break;
            case 9:
                itemView = mInflater.inflate(R.layout.layout_item_moment_num_9, parent, false);
                holder = new MomentHolder9(itemView);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Blog blog = mDataList.get(position);
        ((MomentBaseHolder) holder).update(blog);
    }

    @Override
    public int getItemViewType(int position) {
        Blog blog = mDataList.get(position);
        return blog.urls.size();
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    class MomentHolder1 extends MomentBaseHolder {
        public MomentHolder1(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            iv1 = (SimpleDraweeView) itemView.findViewById(R.id.iv_1);
        }

        public void update(Blog blog) {
            if (blog == null) {
                return;
            }
            tvName.setText(blog.name);
            iv1.setImageURI(Uri.parse(blog.urls.get(0)));
        }

        public TextView tvName;
        public SimpleDraweeView iv1;

    }

    class MomentHolder2 extends MomentBaseHolder {
        public MomentHolder2(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            layoutRow1 = (LinearLayout) itemView.findViewById(R.id.layout_row_1);
        }

        public void update(Blog blog) {
            if (blog == null) {
                return;
            }
            tvName.setText(blog.name);
            ((SimpleDraweeView) layoutRow1.getChildAt(0)).setImageURI(Uri.parse(blog.urls.get(0)));
            ((SimpleDraweeView) layoutRow1.getChildAt(1)).setImageURI(Uri.parse(blog.urls.get(1)));
        }

        public TextView tvName;
        public LinearLayout layoutRow1;
    }

    class MomentHolder3 extends MomentBaseHolder {
        public MomentHolder3(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            layoutRow1 = (LinearLayout) itemView.findViewById(R.id.layout_row_1);
        }

        public void update(Blog blog) {
            if (blog == null) {
                return;
            }
            tvName.setText(blog.name);
            ((SimpleDraweeView) layoutRow1.getChildAt(0)).setImageURI(Uri.parse(blog.urls.get(0)));
            ((SimpleDraweeView) layoutRow1.getChildAt(1)).setImageURI(Uri.parse(blog.urls.get(1)));
            ((SimpleDraweeView) layoutRow1.getChildAt(2)).setImageURI(Uri.parse(blog.urls.get(2)));
        }

        public TextView tvName;
        public LinearLayout layoutRow1;
    }

    class MomentHolder4 extends MomentBaseHolder {
        public MomentHolder4(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            layoutRow1 = (LinearLayout) itemView.findViewById(R.id.layout_row_1);
            layoutRow2 = (LinearLayout) itemView.findViewById(R.id.layout_row_2);
        }

        public void update(Blog blog) {
            if (blog == null) {
                return;
            }
            tvName.setText(blog.name);
            ((SimpleDraweeView) layoutRow1.getChildAt(0)).setImageURI(Uri.parse(blog.urls.get(0)));
            ((SimpleDraweeView) layoutRow1.getChildAt(1)).setImageURI(Uri.parse(blog.urls.get(1)));
            ((SimpleDraweeView) layoutRow2.getChildAt(0)).setImageURI(Uri.parse(blog.urls.get(2)));
            ((SimpleDraweeView) layoutRow2.getChildAt(1)).setImageURI(Uri.parse(blog.urls.get(3)));
        }

        public TextView tvName;
        public LinearLayout layoutRow1;
        public LinearLayout layoutRow2;
    }

    class MomentHolder5 extends MomentBaseHolder {
        public MomentHolder5(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            layoutRow1 = (LinearLayout) itemView.findViewById(R.id.layout_row_1);
            layoutRow2 = (LinearLayout) itemView.findViewById(R.id.layout_row_2);
        }

        public void update(Blog blog) {
            if (blog == null) {
                return;
            }
            tvName.setText(blog.name);
            ((SimpleDraweeView) layoutRow1.getChildAt(0)).setImageURI(Uri.parse(blog.urls.get(0)));
            ((SimpleDraweeView) layoutRow1.getChildAt(1)).setImageURI(Uri.parse(blog.urls.get(1)));
            ((SimpleDraweeView) layoutRow1.getChildAt(2)).setImageURI(Uri.parse(blog.urls.get(2)));
            ((SimpleDraweeView) layoutRow2.getChildAt(0)).setImageURI(Uri.parse(blog.urls.get(3)));
            ((SimpleDraweeView) layoutRow2.getChildAt(1)).setImageURI(Uri.parse(blog.urls.get(4)));
        }

        public TextView tvName;
        public LinearLayout layoutRow1;
        public LinearLayout layoutRow2;
    }

    class MomentHolder6 extends MomentBaseHolder {
        public MomentHolder6(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            layoutRow1 = (LinearLayout) itemView.findViewById(R.id.layout_row_1);
            layoutRow2 = (LinearLayout) itemView.findViewById(R.id.layout_row_2);
        }

        public void update(Blog blog) {
            if (blog == null) {
                return;
            }
            tvName.setText(blog.name);
            ((SimpleDraweeView) layoutRow1.getChildAt(0)).setImageURI(Uri.parse(blog.urls.get(0)));
            ((SimpleDraweeView) layoutRow1.getChildAt(1)).setImageURI(Uri.parse(blog.urls.get(1)));
            ((SimpleDraweeView) layoutRow1.getChildAt(2)).setImageURI(Uri.parse(blog.urls.get(2)));
            ((SimpleDraweeView) layoutRow2.getChildAt(0)).setImageURI(Uri.parse(blog.urls.get(3)));
            ((SimpleDraweeView) layoutRow2.getChildAt(1)).setImageURI(Uri.parse(blog.urls.get(4)));
            ((SimpleDraweeView) layoutRow2.getChildAt(2)).setImageURI(Uri.parse(blog.urls.get(5)));
        }

        public TextView tvName;
        public LinearLayout layoutRow1;
        public LinearLayout layoutRow2;
    }

    class MomentHolder7 extends MomentBaseHolder {
        public MomentHolder7(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            layoutRow1 = (LinearLayout) itemView.findViewById(R.id.layout_row_1);
            layoutRow2 = (LinearLayout) itemView.findViewById(R.id.layout_row_2);
            layoutRow3 = (LinearLayout) itemView.findViewById(R.id.layout_row_3);
        }

        public void update(Blog blog) {
            if (blog == null) {
                return;
            }
            tvName.setText(blog.name);
            ((SimpleDraweeView) layoutRow1.getChildAt(0)).setImageURI(Uri.parse(blog.urls.get(0)));
            ((SimpleDraweeView) layoutRow1.getChildAt(1)).setImageURI(Uri.parse(blog.urls.get(1)));
            ((SimpleDraweeView) layoutRow1.getChildAt(2)).setImageURI(Uri.parse(blog.urls.get(2)));
            ((SimpleDraweeView) layoutRow2.getChildAt(0)).setImageURI(Uri.parse(blog.urls.get(3)));
            ((SimpleDraweeView) layoutRow2.getChildAt(1)).setImageURI(Uri.parse(blog.urls.get(4)));
            ((SimpleDraweeView) layoutRow2.getChildAt(2)).setImageURI(Uri.parse(blog.urls.get(5)));
            ((SimpleDraweeView) layoutRow3.getChildAt(0)).setImageURI(Uri.parse(blog.urls.get(6)));
        }

        public TextView tvName;
        public LinearLayout layoutRow1;
        public LinearLayout layoutRow2;
        public LinearLayout layoutRow3;
    }

    class MomentHolder8 extends MomentBaseHolder {
        public MomentHolder8(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            layoutRow1 = (LinearLayout) itemView.findViewById(R.id.layout_row_1);
            layoutRow2 = (LinearLayout) itemView.findViewById(R.id.layout_row_2);
            layoutRow3 = (LinearLayout) itemView.findViewById(R.id.layout_row_3);
        }

        public void update(Blog blog) {
            if (blog == null) {
                return;
            }
            tvName.setText(blog.name);
            ((SimpleDraweeView) layoutRow1.getChildAt(0)).setImageURI(Uri.parse(blog.urls.get(0)));
            ((SimpleDraweeView) layoutRow1.getChildAt(1)).setImageURI(Uri.parse(blog.urls.get(1)));
            ((SimpleDraweeView) layoutRow1.getChildAt(2)).setImageURI(Uri.parse(blog.urls.get(2)));
            ((SimpleDraweeView) layoutRow2.getChildAt(0)).setImageURI(Uri.parse(blog.urls.get(3)));
            ((SimpleDraweeView) layoutRow2.getChildAt(1)).setImageURI(Uri.parse(blog.urls.get(4)));
            ((SimpleDraweeView) layoutRow2.getChildAt(2)).setImageURI(Uri.parse(blog.urls.get(5)));
            ((SimpleDraweeView) layoutRow3.getChildAt(0)).setImageURI(Uri.parse(blog.urls.get(6)));
            ((SimpleDraweeView) layoutRow3.getChildAt(1)).setImageURI(Uri.parse(blog.urls.get(7)));
        }

        public TextView tvName;
        public LinearLayout layoutRow1;
        public LinearLayout layoutRow2;
        public LinearLayout layoutRow3;
    }

    class MomentHolder9 extends MomentBaseHolder {
        public MomentHolder9(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            layoutRow1 = (LinearLayout) itemView.findViewById(R.id.layout_row_1);
            layoutRow2 = (LinearLayout) itemView.findViewById(R.id.layout_row_2);
            layoutRow3 = (LinearLayout) itemView.findViewById(R.id.layout_row_3);
        }

        public void update(Blog blog) {
            if (blog == null) {
                return;
            }
            tvName.setText(blog.name);
            ((SimpleDraweeView) layoutRow1.getChildAt(0)).setImageURI(Uri.parse(blog.urls.get(0)));
            ((SimpleDraweeView) layoutRow1.getChildAt(1)).setImageURI(Uri.parse(blog.urls.get(1)));
            ((SimpleDraweeView) layoutRow1.getChildAt(2)).setImageURI(Uri.parse(blog.urls.get(2)));
            ((SimpleDraweeView) layoutRow2.getChildAt(0)).setImageURI(Uri.parse(blog.urls.get(3)));
            ((SimpleDraweeView) layoutRow2.getChildAt(1)).setImageURI(Uri.parse(blog.urls.get(4)));
            ((SimpleDraweeView) layoutRow2.getChildAt(2)).setImageURI(Uri.parse(blog.urls.get(5)));
            ((SimpleDraweeView) layoutRow3.getChildAt(0)).setImageURI(Uri.parse(blog.urls.get(6)));
            ((SimpleDraweeView) layoutRow3.getChildAt(1)).setImageURI(Uri.parse(blog.urls.get(7)));
            ((SimpleDraweeView) layoutRow3.getChildAt(2)).setImageURI(Uri.parse(blog.urls.get(8)));
        }

        public TextView tvName;
        public LinearLayout layoutRow1;
        public LinearLayout layoutRow2;
        public LinearLayout layoutRow3;
    }
}
