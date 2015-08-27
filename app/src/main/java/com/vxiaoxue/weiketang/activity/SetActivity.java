package com.vxiaoxue.weiketang.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.vxiaoxue.weiketang.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 系统设置页面
 * Created by Administrator on 2015/8/22.
 */
public class SetActivity extends BaseActivity implements View.OnClickListener {
    @InjectView(R.id.set_return)
    ImageView setReturn;
    @InjectView(R.id.set_data)
    ImageButton setData;
    @InjectView(R.id.set_opinion)
    ImageButton setOpinion;
    @InjectView(R.id.set_about)
    ImageButton setAbout;
    @InjectView(R.id.set_record)
    ImageButton setRecord;
    @InjectView(R.id.set_faction)
    ImageButton setFaction;
    @InjectView(R.id.set_system)
    ImageButton setSystem;
    @InjectView(R.id.set_update)
    ImageButton setUpdate;
    @InjectView(R.id.set_cancellation)
    ImageButton setCancellation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.inject(this);
        initView();
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        setReturn.setOnClickListener(this);
        setData.setOnClickListener(this);
        setFaction.setOnClickListener(this);
        setAbout.setOnClickListener(this);
        setOpinion.setOnClickListener(this);
        setSystem.setOnClickListener(this);
        setCancellation.setOnClickListener(this);
        setRecord.setOnClickListener(this);
        setUpdate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.set_return://返回
                startActivity(new Intent(this,PreActivity.class));
                overridePendingTransition(R.anim.pre_in,R.anim.pre_out);
                finish();
                break;
            case R.id.set_data://个人资料
                startActivity(new Intent(this,SetDataActivity.class));
                break;
            case R.id.set_about://关于我们
                startActivity(new Intent(this,AboutActivity.class));
                break;
            case R.id.set_cancellation://注销
                break;
            case R.id.set_faction://功能介绍
                startActivity(new Intent(this,FactionActivity.class));
                break;
            case R.id.set_opinion://意见建议页面
                startActivity(new Intent(this,OpinionActivity.class));
                break;
            case R.id.set_record://消费记录页面
                startActivity(new Intent(this,RecordActivity.class));
                break;
            case R.id.set_system://系统设置页面
                startActivity(new Intent(this,SystemActivity.class));
                break;
            case R.id.set_update://系统更新页面
                break;
        }
    }
}
