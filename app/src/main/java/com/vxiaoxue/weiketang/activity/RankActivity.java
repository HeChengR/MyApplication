package com.vxiaoxue.weiketang.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

import com.vxiaoxue.weiketang.R;
import com.vxiaoxue.weiketang.adapter.GmAdapter;
import com.vxiaoxue.weiketang.adapter.MyViewHolder;
import com.vxiaoxue.weiketang.domain.RankModal;
import com.vxiaoxue.weiketang.ui.font.TextViewMagic;
import com.vxiaoxue.weiketang.ui.lv.XListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 排行榜
 * Created by Administrator on 2015/8/19.
 */
public class RankActivity extends BaseActivity implements XListView.IXListViewListener {
    @InjectView(R.id.rank_listView)
    XListView rankListView;
    @InjectView(R.id.rank_number_main)
    TextViewMagic rankNumberMain;
    private RankAdapter rankAdapter;
    private List<RankModal> rankList;
    private Handler mHandler;
    private int start = 0;
    private int end = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank_list);
        ButterKnife.inject(this);
        initData();
        rankAdapter = new RankAdapter(this,rankList,R.layout.rank_item);
        rankListView.setAdapter(rankAdapter);
        mHandler = new Handler();
        rankListView.setPullLoadEnable(true);
        rankListView.setXListViewListener(this);
//        //名次数字从上到下渐变效果
//        LinearGradient shape = new LinearGradient(0,0,0,20, 0xfffff46d,0xffffd70c, Shader.TileMode.CLAMP);
//        rankNumberMain.getPaint().setShader(shape);
//        Shader shape = new LinearGradient(0, 0, 0, rankNumberMain.getHeight(), new int[]{0xfffff46d, 0xffffef57, 0xffffeb3d, 0xffffe120, 0xffffdd19, 0xffffd70c}, new float[]{0, 0.2f, 0.5f, 0.7f, 0.9f, 1}, Shader.TileMode.CLAMP);
//        rankNumberMain.getPaint().setShader(shape);
    }



    @Override
    public void onRefresh() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                start = ++end;
                rankList.clear();
                initData();
                rankListView.setAdapter(rankAdapter);
                onLoad();
            }
        }, 2000);
    }

    @Override
    public void onLoadMore() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                initData();
                rankAdapter.notifyDataSetChanged();
                onLoad();
            }
        }, 2000);
    }

    private void onLoad() {
        rankListView.stopRefresh();
        rankListView.stopLoadMore();
        rankListView.setRefreshTime("刚刚");
    }

    //初始化数据
    public void initData() {
        rankList = new ArrayList<>();
        for (int index = 0; index < 10; index++) {
            RankModal rankInfo = new RankModal();
            rankInfo.setIcon(getResources().getDrawable(R.mipmap.myself_phb_pic_01));
            rankInfo.setName("哥要当海贼王" + (++start));
            rankInfo.setTitle("奥数");
            rankInfo.setNumber("16%");
            rankList.add(rankInfo);
        }
    }

    public class RankAdapter extends GmAdapter{

        public RankAdapter(Context context, List mDatas, int itemLayoutId) {
            super(context, mDatas, itemLayoutId);
        }

        @Override
        public void convert(MyViewHolder helper, Object item, int position) {
          RankModal modal =(RankModal)item;
            helper.setImageResource(R.id.rank_icon,modal.getIcon());
            helper.setText(R.id.rank_name, modal.getName());
            helper.setText(R.id.rank_title, modal.getTitle());
            helper.setText(R.id.rank_number,modal.getNumber());
        }
    }
}
