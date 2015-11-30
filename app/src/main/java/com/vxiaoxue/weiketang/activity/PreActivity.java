package com.vxiaoxue.weiketang.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

import com.vxiaoxue.weiketang.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2015/8/19.
 */
public class PreActivity extends BaseActivity implements View.OnClickListener {

    @InjectView(R.id.MyGood)
    ImageButton MyGood;
    @InjectView(R.id.NavigationEvent)
    ImageButton NavigationEvent;
    @InjectView(R.id.IntegralRecord)
    ImageButton IntegralRecord;
    @InjectView(R.id.WrongQuestion)
    ImageButton WrongQuestion;
    @InjectView(R.id.MilePost)
    ImageButton MilePost;
    @InjectView(R.id.Collection)
    ImageButton Collection;
    @InjectView(R.id.RankList)
    ImageButton RankList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        ButterKnife.inject(this);
        initViews();
    }
    //初始化视图监听器
    private void initViews() {
        Collection.setOnClickListener(this);
        MyGood.setOnClickListener(this);
        IntegralRecord.setOnClickListener(this);
        NavigationEvent.setOnClickListener(this);
        MilePost.setOnClickListener(this);
        RankList.setOnClickListener(this);
        WrongQuestion.setOnClickListener(this);
    }
    //点击进入个人中心七大模块页面
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.MyGood://我的物品
                startActivity(new Intent(this, GoodActivity.class));
                break;
            case R.id.NavigationEvent://航海大事记
                startActivity(new Intent(this, NavigationEventActivity.class));
                break;
            case R.id.IntegralRecord://积分记录
                startActivity(new Intent(this, IntegralRecordActivity.class));
                break;
            case R.id.MilePost://我的里程碑
                startActivity(new Intent(this, MilePostActivity.class));
                break;
            case R.id.Collection://我的收藏
                startActivity(new Intent(this, CollectionActivity.class));
                break;
            case R.id.WrongQuestion://错题本
                startActivity(new Intent(this, WrongQuestionActivity.class));
                break;
            case R.id.RankList://排行榜
                startActivity(new Intent(this, RankActivity.class));
                break;
        }
    }

    //返回键退出页面（带有退出动画）
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            finish();
            overridePendingTransition(R.anim.fade, R.anim.hold);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
