package com.vxiaoxue.weiketang.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.vxiaoxue.weiketang.R;
import com.vxiaoxue.weiketang.adapter.GmAdapter;
import com.vxiaoxue.weiketang.adapter.MyViewHolder;
import com.vxiaoxue.weiketang.domain.RecordInfo;
import com.vxiaoxue.weiketang.ui.swipe.SwipeMenu;
import com.vxiaoxue.weiketang.ui.swipe.SwipeMenuCreator;
import com.vxiaoxue.weiketang.ui.swipe.SwipeMenuItem;
import com.vxiaoxue.weiketang.ui.swipe.SwipeMenuListView;
import com.vxiaoxue.weiketang.utils.DensityUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 积分记录
 * Created by Administrator on 2015/8/19.
 */
public class IntegralRecordActivity extends BaseActivity implements View.OnClickListener {

    @InjectView(R.id.record_listView)
    SwipeMenuListView recordListView;
    @InjectView(R.id.total_record)
    RadioButton totalRecord;
    @InjectView(R.id.obtain_record)
    RadioButton obtainRecord;
    @InjectView(R.id.expend_record)
    RadioButton expendRecord;

    private RecordAdapter mRecordAdapter;//积分数据适配器类

    private List<RecordInfo> totalList = new ArrayList<>();//总积分数据集合
    private List<RecordInfo> obtainList = new ArrayList<>();//获取积分数据集合
    private List<RecordInfo> expendList = new ArrayList<>();//消耗积分的数据集合

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integral_record);
        ButterKnife.inject(this);

        initViews();
        initData();


    }

    /**
     * 初始化视图
     */
    public void initViews() {
        totalRecord.setOnClickListener(this);
        obtainRecord.setOnClickListener(this);
        expendRecord.setOnClickListener(this);
        setAdapter(totalList);
    }

    //初始化一些数据
    public void initData() {
        for (int i = 0; i < 8; i++) {
            RecordInfo totalInfo = new RecordInfo();
            totalInfo.setReward("签到奖励：+" + i + "微币");
            totalInfo.setDate("2015-08-21");
            totalList.add(totalInfo);
        }
        for (int i = 0; i < 4; i++) {
            RecordInfo obtainInfo = new RecordInfo();
            obtainInfo.setReward("签到奖励：+" + i + "微币");
            obtainInfo.setDate("2015-08-21");
            obtainList.add(obtainInfo);
        }
        for (int i = 0; i < 2; i++) {
            RecordInfo ExpendInfo = new RecordInfo();
            ExpendInfo.setReward("签到奖励：+" + i + "微币");
            ExpendInfo.setDate("2015-08-21");
            expendList.add(ExpendInfo);
        }
    }

    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.total_record:

                setAdapter(totalList);
                break;
            case R.id.obtain_record:

                setAdapter(obtainList);
                break;
            case R.id.expend_record:

                setAdapter(expendList);
                break;
        }
    }

    //设置数据填充器，根据点击不同的按钮去切换数据。
    public void setAdapter(final List<RecordInfo> list) {
        mRecordAdapter = new RecordAdapter(this, list, R.layout.integral_record_item);
        recordListView.setAdapter(mRecordAdapter);

        SwipeMenuCreator createor = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                deleteItem.setBackground(R.color.red);
                deleteItem.setWidth(DensityUtil.dip2px(IntegralRecordActivity.this, 50));
                deleteItem.setIcon(R.mipmap.ic_delete);
                menu.addMenuItem(deleteItem);
            }
        };

        recordListView.setMenuCreator(createor);

        recordListView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClick(int position, SwipeMenu menu, int index) {
                list.remove(position);
                mRecordAdapter.notifyDataSetChanged();
            }
        });

    }

    //数据适配器类
    public class RecordAdapter extends GmAdapter<RecordInfo> {
        //第一个参数是上下文环境，第二个参数是数据的集合，第三个参数是子View布局Xml文件转化为View对象
        public RecordAdapter(Context context, List mDatas, int itemLayoutId) {
            super(context, mDatas, itemLayoutId);
        }

        @Override
        public void convert(MyViewHolder helper, final RecordInfo item, int position) {
            helper.setText(R.id.reward_item, item.getReward());
            helper.setText(R.id.date_item, item.getDate());
        }
    }
}
