package com.vxiaoxue.weiketang.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.vxiaoxue.weiketang.R;
import com.vxiaoxue.weiketang.domain.CollectionInfo;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Administrator on 2015/8/26.
 */
public class CacheFragment extends Fragment {
    private ArrayList<CollectionInfo> CacheList;
    private CollectionInfo collectionInfo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.collection_fragment, container);
        ListView collection_listView = (ListView) view.findViewById(R.id.collection_listView);
        CacheAdapter cacheAdapter = new CacheAdapter();
        collection_listView.setAdapter(cacheAdapter);

        CacheList = new ArrayList<>();
        collectionInfo = new CollectionInfo();
        Random random = new Random();
        int progress = random.nextInt();
        for (int index = 0; index < 10; index ++) {
            collectionInfo.setIBackground(getResources().getDrawable(R.mipmap.plaer_bg_03));
            collectionInfo.setCourseName("课程名称" + index);
            collectionInfo.setCourseDes("课程描述" + index);
            collectionInfo.setCacheProgress("缓存进度：" + progress + "%");
            CacheList.add(collectionInfo);
        }
        return view;
    }


    public class CacheAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            System.out.print(CacheList.size());
            return CacheList.size();
        }

        @Override
        public CollectionInfo getItem(int position) {
            return CacheList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = View.inflate(getActivity(), R.layout.cache_item, null);
                viewHolder = new ViewHolder();
                viewHolder.IvBackground = (ImageView) convertView.findViewById(R.id.cache_video_background);
                viewHolder.TvName = (TextView) convertView.findViewById(R.id.cache_name);
                viewHolder.TvNameDes = (TextView) convertView.findViewById(R.id.cache_name_description);
                viewHolder.TvProgress = (TextView) convertView.findViewById(R.id.cache_progress);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            CollectionInfo collectionInfo = getItem(position);
            viewHolder.IvBackground.setImageDrawable(collectionInfo.getIBackground());
            viewHolder.TvName.setText(collectionInfo.getCourseName());
            viewHolder.TvNameDes.setText(collectionInfo.getCourseDes());
            viewHolder.TvProgress.setText(collectionInfo.getCacheProgress());
            return convertView;
        }
    }

    static class ViewHolder {
        public ImageView IvBackground;
        public TextView TvName;
        public TextView TvNameDes;
        public TextView TvProgress;
    }
}
