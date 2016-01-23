package com.androidapp.yanx.testfloating.adapter;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidapp.yanx.testfloating.R;
import com.androidapp.yanx.testfloating.utils.DeviceUtil;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

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
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemHolder) {
            String url = urls.get(position);
//            ((ItemHolder) holder).ivPicture.setImageURI();
            holder.itemView.setTag(url);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.OnItemClick(v);
                    }
                }
            });
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((ItemHolder) holder).ivPicture.getTag();

            final int index = position;
            DraweeController controller = Fresco.newDraweeControllerBuilder().setUri(Uri.parse(url)).setControllerListener(new BaseControllerListener<ImageInfo>() {
                @Override
                public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                    super.onFinalImageSet(id, imageInfo, animatable);
                    float factor = imageInfo.getHeight() * 1.0f / imageInfo.getWidth() * 1.0f;
                    layoutParams.height = (int) (layoutParams.width * factor);
                    ((ItemHolder) holder).ivPicture.setLayoutParams(layoutParams);
                    ((ItemHolder) holder).tvTitle.setText("ID:" + id);
                    ((ItemHolder) holder).tvTitle.append("\n");
                    ((ItemHolder) holder).tvTitle.append("This is picture " + index);
                    ((ItemHolder) holder).tvTitle.append("\n");
                    ((ItemHolder) holder).tvTitle.append(imageInfo.getWidth() + "_" + imageInfo.getHeight());
                    ((ItemHolder) holder).tvTitle.append("\n");
                    ((ItemHolder) holder).tvTitle.append("isOfFullQuality : " + imageInfo.getQualityInfo().isOfFullQuality() + ", isOfGoodEnoughQuality : " + imageInfo.getQualityInfo().isOfGoodEnoughQuality());
                }


                @Override
                public void onFailure(String id, Throwable throwable) {
                    super.onFailure(id, throwable);
                    ((ItemHolder) holder).tvTitle.setText("ID:" + id);
                    ((ItemHolder) holder).tvTitle.append("\n");
                    ((ItemHolder) holder).tvTitle.append("This is picture " + index);
                    ((ItemHolder) holder).tvTitle.append("\n");
                    ((ItemHolder) holder).tvTitle.append("Load picture fail!!!");
                }
            }).build();
            ((ItemHolder) holder).ivPicture.setController(controller);


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
            layoutParams = new RelativeLayout.LayoutParams((int) (DeviceUtil.getScreenSize(mContext)[0] * 0.7), DeviceUtil.getScreenSize(mContext)[0] / 2);
            layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
            ivPicture = (SimpleDraweeView) itemView.findViewById(R.id.iv_picture);
            ivPicture.setLayoutParams(layoutParams);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            ivPicture.setTag(layoutParams);
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
