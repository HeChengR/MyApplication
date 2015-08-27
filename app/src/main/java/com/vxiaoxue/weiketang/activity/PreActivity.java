package com.vxiaoxue.weiketang.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.vxiaoxue.weiketang.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2015/8/19.
 */
public class PreActivity extends Activity implements View.OnClickListener {


    @InjectView(R.id.iv_good)
    ImageView ivGood;
    @InjectView(R.id.iv_milePost)
    ImageView ivMilePost;
    @InjectView(R.id.iv_navigationEvents)
    ImageView ivNavigationEvents;
    @InjectView(R.id.iv_collection)
    ImageView ivCollection;
    @InjectView(R.id.iv_integralRecord)
    ImageView ivIntegralRecord;
    @InjectView(R.id.iv_wrongQuestion)
    ImageView ivWrongQuestion;
    @InjectView(R.id.iv_rankList)
    ImageView ivRankList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //设置全屏显示
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        ButterKnife.inject(this);
        initView();
    }

    //返回
    public void onReturn(View v) {
        finish();
    }

    //进入设置页面
    public void onSet(View v) {
        startActivity(new Intent(this, SetActivity.class));
        AnimActivity(R.anim.pre_in, R.anim.pre_out);
        finish();
    }

    public void initView() {
        ivCollection.setOnClickListener(this);
        ivGood.setOnClickListener(this);
        ivIntegralRecord.setOnClickListener(this);
        ivNavigationEvents.setOnClickListener(this);
        ivMilePost.setOnClickListener(this);
        ivRankList.setOnClickListener(this);
        ivWrongQuestion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_good://我的物品
                startActivity(new Intent(this, GoodActivity.class));
                AnimActivity(R.anim.pre_in, R.anim.pre_out);
                break;
            case R.id.iv_navigationEvents://航海大事记
                startActivity(new Intent(this, NavigationEventActivity.class));
                AnimActivity(R.anim.pre_in, R.anim.pre_out);
                break;
            case R.id.iv_integralRecord://积分记录
                startActivity(new Intent(this, IntegralRecordActivity.class));
                AnimActivity(R.anim.pre_in, R.anim.pre_out);
                break;
            case R.id.iv_milePost://我的里程碑
                startActivity(new Intent(this, MilePostActivity.class));
                AnimActivity(R.anim.pre_in, R.anim.pre_out);
                break;
            case R.id.iv_collection://我的收藏
                startActivity(new Intent(this, CollectionActivity.class));
                AnimActivity(R.anim.pre_in, R.anim.pre_out);
                break;
            case R.id.iv_wrongQuestion://错题本
                startActivity(new Intent(this, WrongQuestionActivity.class));
                AnimActivity(R.anim.pre_in, R.anim.pre_out);
                break;
            case R.id.iv_rankList://排行榜
                startActivity(new Intent(this, RankListActivity.class));
                AnimActivity(R.anim.pre_in, R.anim.pre_out);
                break;
        }
    }


    public void AnimActivity(int in, int out) {
        overridePendingTransition(in, out);
    }
}
