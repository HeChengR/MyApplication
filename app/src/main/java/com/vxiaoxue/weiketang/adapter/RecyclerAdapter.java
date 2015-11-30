package com.vxiaoxue.weiketang.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/11/27.
 */
public abstract class RecyclerAdapter<T> extends RecyclerView.Adapter {
    private LayoutInflater inflater;
    private int LayoutID;
    private View View;
    private ArrayList<T> mImageIds;

    public RecyclerAdapter(Context context, int ViewId, ArrayList<T> mImgIds) {
        inflater = LayoutInflater.from(context);
        this.LayoutID = ViewId;
        this.mImageIds = mImgIds;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View = inflater.inflate(LayoutID, null);
        return new ViewHolder(View);
    }

    @Override
    abstract public void onBindViewHolder(RecyclerView.ViewHolder holder, int position);

    @Override
    public int getItemCount() {
        return mImageIds.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
