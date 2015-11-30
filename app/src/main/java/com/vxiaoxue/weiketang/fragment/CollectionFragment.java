package com.vxiaoxue.weiketang.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
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
 * 我的收藏Fragment
 * Created by Administrator on 2015/8/26.
 */
public class CollectionFragment extends Fragment {
    @InjectView(R.id.collection_listView)
    ListView collectionListView;
    private ArrayList<CollectionInfo> CollectionList;
    private CollectionInfo collectionInfo;
    CollectionAdapter collectionAdapter;//我的收藏数据适配器
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.collection_fragment, container);
        ButterKnife.inject(this, view);

        //封装数据到集合中去（思路：点击收藏将视频信息封装到数据库中，打开我的收藏从数据库中读取数据。（有三个字段信息：视频背景图片、视频名称、视频简介。）日期显示为当前日期。点击取消收藏删除本条记录）
        CollectionList = new ArrayList<>();
        for (int index = 0; index < 10; index++) {
            collectionInfo = new CollectionInfo();
            collectionInfo.setIBackground(getResources().getDrawable(R.mipmap.plaer_bg_03));
            collectionInfo.setCourseName("课程名称" + index);
            collectionInfo.setCourseDes("课程描述" + index);
            CollectionList.add(collectionInfo);
        }
        collectionAdapter = new CollectionAdapter(getActivity(), CollectionList, R.layout.collection_item);
        collectionListView.setAdapter(collectionAdapter);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    //数据展示
    public class CollectionAdapter extends GmAdapter {
        public CollectionAdapter(Context context, List mDatas, int itemLayoutId) {
            super(context, mDatas, itemLayoutId);
        }

        @Override
        public void convert(MyViewHolder helper, Object item, int position) {
            helper.setImageBackground(R.id.collection_fl, ((CollectionInfo) item).getIBackground());
            helper.setText(R.id.collection_name, ((CollectionInfo) item).getCourseName());
            helper.setText(R.id.collection_des, ((CollectionInfo) item).getCourseDes());
        }
    }
}
