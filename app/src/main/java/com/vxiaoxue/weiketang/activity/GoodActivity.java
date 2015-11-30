package com.vxiaoxue.weiketang.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.vxiaoxue.weiketang.R;
import com.vxiaoxue.weiketang.adapter.MyArtAdapter;
import com.vxiaoxue.weiketang.adapter.MyArtPageAdapter;
import com.vxiaoxue.weiketang.domain.ArtModal;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 我的物品页面
 * Created by Administrator on 2015/8/19.
 */
public class GoodActivity extends BaseActivity{
    @InjectView(R.id.good_ViewPager)
    ViewPager goodViewPager;

    private static final float APP_PAGE_SIZE = 8.0f;
    private ArrayList<ArtModal> mArray = new ArrayList();
    private ArrayList<GridView> mGridViewList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good);
        ButterKnife.inject(this);
        initData();
        initViews();
        goodViewPager.setAdapter(new MyArtPageAdapter(this, mGridViewList));
    }


    //初始化视图监听器
    public void initViews() {
        int Page = (int) Math.ceil(mArray.size() / APP_PAGE_SIZE);
        mGridViewList = new ArrayList();
        for (int index = 0; index < Page; index++) {
            GridView mGridView = new GridView(this);
            mGridView.setNumColumns(4);
            mGridView.setAdapter(new MyArtAdapter(GoodActivity.this, mArray, index));
            //点击弹出物品详情页面
            mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    startActivity(new Intent(GoodActivity.this, GoodDetailActivity.class));
                }
            });
            mGridViewList.add(mGridView);
        }
    }

    //模拟数据的初始化
    private void initData() {
        for (int index = 0; index < 20; index++) {
            ArtModal info = new ArtModal();
            info.setDrawable(getResources().getDrawable(R.mipmap.myself_wp_pic_01));
            mArray.add(info);
        }
    }
}
