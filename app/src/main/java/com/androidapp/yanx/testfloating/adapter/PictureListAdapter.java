package com.androidapp.yanx.testfloating.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidapp.yanx.testfloating.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

/**
 * com.androidapp.yanx.testfloating.adapter
 * Created by yanx on 12/5/15 9:12 PM.
 * Description ${TODO}
 */
public class PictureListAdapter extends MyBaseAdapter {

    private ArrayList<String> urls ;

    private LayoutInflater inflater ;

    private void setUrls(ArrayList<String> list){
        if(list == null){
            list = new ArrayList<>() ;
        }
        urls = list ;
    }

    public PictureListAdapter(Context context,ArrayList<String> list){
        setUrls(list);
        inflater = LayoutInflater.from(context) ;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = inflater.inflate(R.layout.layout_item_picture,parent,false) ;
        Holder holder = new Holder(rootView) ;
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String url = urls.get(position) ;
        ((Holder)holder).ivPicture.setImageURI(Uri.parse(url));
        holder.itemView.setTag(url);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener != null){
                    onItemClickListener.OnItemClick(v);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return urls.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        SimpleDraweeView ivPicture ;

        public Holder(View itemView) {
            super(itemView);
            ivPicture = (SimpleDraweeView) itemView.findViewById(R.id.iv_picture);
        }
    }
}
