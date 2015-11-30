package com.vxiaoxue.weiketang.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/11/19.
 */
public class MyArtPageAdapter extends PagerAdapter {
    private ArrayList<GridView> array;

    /**
     * @param context
     * @param list
     */
    public MyArtPageAdapter(Context context, ArrayList<GridView> list) {
        array = list;
    }

    @Override
    public int getCount() {
        return array.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(array.get(position));
        return array.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
