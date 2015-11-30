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
import com.vxiaoxue.weiketang.adapter.GmAdapter;
import com.vxiaoxue.weiketang.adapter.MyViewHolder;
import com.vxiaoxue.weiketang.domain.CollectionInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 我的缓存Fragment
 * Created by Administrator on 2015/8/26.
 */
public class CacheFragment extends Fragment {
    @InjectView(R.id.collection_listView)
    ListView collectionListView;
    private ArrayList<CollectionInfo> CacheList;
    private CollectionInfo cacheInfo;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.collection_fragment, container);
        ButterKnife.inject(this, view);
        CacheList = new ArrayList<>();

        for (int index = 0; index < 10; index++) {
            cacheInfo = new CollectionInfo();
            cacheInfo.setIBackground(getResources().getDrawable(R.mipmap.plaer_bg_03));
            cacheInfo.setCourseName("课程名称" + index);
            cacheInfo.setCourseDes("课程描述" + index);
            CacheList.add(cacheInfo);
        }
        collectionListView.setAdapter(new CacheAdapter(getActivity(), CacheList, R.layout.cache_item));

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    class CacheAdapter extends GmAdapter {

        public CacheAdapter(Context context, List mDatas, int itemLayoutId) {
            super(context, mDatas, itemLayoutId);
        }

        @Override
        public void convert(MyViewHolder helper, Object item, int position) {
            helper.setImageBackground(R.id.cache_video_background, ((CollectionInfo) item).getIBackground());
            helper.setText(R.id.cache_name, ((CollectionInfo) item).getCourseName());
            helper.setText(R.id.cache_name_description, ((CollectionInfo) item).getCourseDes());
            helper.setText(R.id.cache_progress, "缓存进度：" + (int) (Math.random() * 100) + "%");
        }
    }
}
