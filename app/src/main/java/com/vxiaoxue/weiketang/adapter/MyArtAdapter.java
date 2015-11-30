package com.vxiaoxue.weiketang.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.vxiaoxue.weiketang.R;
import com.vxiaoxue.weiketang.domain.ArtModal;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/11/19.
 */
public class MyArtAdapter extends BaseAdapter {
    private static final int APP_VIEW_SIZE = 8;//当前页View的个数
    private ArrayList<ArtModal> ArtList = new ArrayList<>();
    private Context mContext;

    public MyArtAdapter(Context context, ArrayList<ArtModal> mArray, int Page) {
        this.mContext = context;
        int StartView = Page * APP_VIEW_SIZE;//当前页的第一个view
        final int EndView = StartView + APP_VIEW_SIZE;//当前页的最后一个view
        while ((StartView < mArray.size()) && (StartView < EndView)) {
            ArtList.add(mArray.get(StartView));
            StartView++;
        }
    }

    @Override
    public int getCount() {
        return ArtList.size();
    }

    @Override
    public Object getItem(int position) {
        return ArtList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.good_item, null);
        }
        ArtModal info = ArtList.get(position);
        ImageView good_item = (ImageView) convertView.findViewById(R.id.iv_good_item);
        good_item.setImageDrawable(info.getDrawable());
        return convertView;
    }
}
