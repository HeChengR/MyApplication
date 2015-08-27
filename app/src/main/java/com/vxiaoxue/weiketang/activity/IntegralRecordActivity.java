package com.vxiaoxue.weiketang.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.vxiaoxue.weiketang.R;
import com.vxiaoxue.weiketang.adapter.ListViewAdapter;
import com.vxiaoxue.weiketang.adapter.ViewHolder;
import com.vxiaoxue.weiketang.domain.RecordInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 积分记录
 * Created by Administrator on 2015/8/19.
 */
public class IntegralRecordActivity extends BaseActivity implements View.OnClickListener{
    @InjectView(R.id.total_record)
    ImageButton totalRecord;
    @InjectView(R.id.obtain_record)
    ImageButton obtainRecord;
    @InjectView(R.id.expend_record)
    ImageButton expendRecord;
    @InjectView(R.id.record_listView)
    ListView recordListView;

    private RecordAdapter mRecordAdapter;//积分数据适配器类

    private List<RecordInfo> totalList = new ArrayList<>();//总积分数据集合
    private List<RecordInfo> obtainList = new ArrayList<>();//获取积分数据集合
    private List<RecordInfo> expendList = new ArrayList<>();//消耗积分的数据集合

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integral_record);
        ButterKnife.inject(this);
        totalRecord.setSelected(true);
        initView();
        initData();
    }

    //返回
    public void onReturn(View v) {
        finish();
    }

    //进入设置页面
    public void onSet(View v) {

    }

    /**
     * 初始化视图
     */
    @Override
    public void initView() {
        totalRecord.setOnClickListener(this);
        obtainRecord.setOnClickListener(this);
        expendRecord.setOnClickListener(this);

        setAdapter(totalList);
    }

    //初始化一些数据
    @Override
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
                totalRecord.setSelected(true);
                obtainRecord.setSelected(false);
                expendRecord.setSelected(false);
                setAdapter(totalList);
                break;
            case R.id.obtain_record:
                totalRecord.setSelected(false);
                obtainRecord.setSelected(true);
                expendRecord.setSelected(false);
                setAdapter(obtainList);
                break;
            case R.id.expend_record:
                totalRecord.setSelected(false);
                obtainRecord.setSelected(false);
                expendRecord.setSelected(true);
                setAdapter(expendList);
                break;
        }
    }

    //设置数据填充器，根据点击不同的按钮去切换数据。
    public void setAdapter(List<RecordInfo> list) {
        mRecordAdapter = new RecordAdapter(this, list, R.layout.integral_record_item);
        recordListView.setAdapter(mRecordAdapter);
    }

    //数据适配器类
    public class RecordAdapter extends ListViewAdapter<RecordInfo> {
        //第一个参数是上下文环境，第二个参数是数据的集合，第三个参数是子View布局Xml文件转化为View对象
        public RecordAdapter(Context context, List mDatas, int itemLayoutId) {
            super(context, mDatas, itemLayoutId);
        }

        @Override
        public void convert(ViewHolder helper, final RecordInfo item) {
            helper.setText(R.id.reward_item, item.getReward());
            helper.setText(R.id.date_item, item.getDate());
           View view =  helper.getConvertView();
           Button bt_delete = (Button) view.findViewById(R.id.bt_delete);
            bt_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDatas.remove(item);
                    notifyDataSetChanged();
                }
            });
        }
    }
}
