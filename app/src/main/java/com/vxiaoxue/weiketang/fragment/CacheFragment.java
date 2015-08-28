package com.vxiaoxue.weiketang.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.vxiaoxue.weiketang.R;
import com.vxiaoxue.weiketang.adapter.ListViewAdapter;
import com.vxiaoxue.weiketang.adapter.ViewHolder;
import com.vxiaoxue.weiketang.domain.CollectionInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/8/26.
 */
public class CacheFragment extends Fragment {
    private ArrayList<CollectionInfo> CacheList;
    private CollectionInfo collectionInfo;

    private ListView collection_listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.collection_fragment, container);
        collection_listView = (ListView) view.findViewById(R.id.collection_listView);
        CacheList = new ArrayList<>();

        for (int index = 0; index < 10; index++) {
            collectionInfo = new CollectionInfo();
            collectionInfo.setIBackground(getResources().getDrawable(R.mipmap.plaer_bg_03));
            collectionInfo.setCourseName("课程名称" + index);
            collectionInfo.setCourseDes("课程描述" + index);
            collectionInfo.setCacheProgress("缓存进度：" + (int) (Math.random() * 100) + "%");
            CacheList.add(collectionInfo);
        }

        CacheAdapter cacheAdapter = new CacheAdapter(getActivity(), CacheList, R.layout.cache_item);
        collection_listView.setAdapter(cacheAdapter);
        return view;
    }

    public class CacheAdapter extends ListViewAdapter {
        public CacheAdapter(Context context, List mDatas, int itemLayoutId) {
            super(context, mDatas, itemLayoutId);
        }

        @Override
        public void convert(ViewHolder helper, Object item) {
             helper.setImageResource(R.id.cache_video_background, ((CollectionInfo)item).getIBackground());
             helper.setText(R.id.cache_name,((CollectionInfo)item).getCourseName());
             helper.setText(R.id.cache_name_description,((CollectionInfo)item).getCourseDes());
             helper.setText(R.id.cache_progress,((CollectionInfo)item).getCacheProgress());
        }
    }
}
