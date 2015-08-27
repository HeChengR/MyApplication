package com.vxiaoxue.weiketang.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.vxiaoxue.weiketang.R;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends Activity implements View.OnClickListener {
    @InjectView(R.id.iv_personal_center)
    ImageView ivPersonalCenter;
    @InjectView(R.id.iv_chart)
    ImageView ivChart;
    @InjectView(R.id.iv_shop)
    ImageView ivShop;
    @InjectView(R.id.iv_task)
    ImageView ivTask;
    @InjectView(R.id.iv_attendance)
    ImageView ivAttendance;
    @InjectView(R.id.user_name)
    TextView userName;
    @InjectView(R.id.see_medal)
    TextView seeMedal;
    @InjectView(R.id.tv_progress_name)
    TextView tvProgressName;

    private Typeface mTypeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initView();
    }

    //初始化视图
    public void initView() {
        //引入自定义字体，后期可能会优化，应用启动时将字体写入手机sd卡，将应用内字体删除，避免应用包变大。
        mTypeface = Typeface.createFromAsset(getAssets(), "fonts/ttf.TTF");
        userName.setTypeface(mTypeface);
        seeMedal.setTypeface(mTypeface);
        tvProgressName.setTypeface(mTypeface);

        ivAttendance.setOnClickListener(this);
        ivChart.setOnClickListener(this);
        ivPersonalCenter.setOnClickListener(this);
        ivTask.setOnClickListener(this);
        ivShop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_attendance://签到
                break;
            case R.id.iv_chart://起航
                break;
            case R.id.iv_shop://商城
                break;
            case R.id.iv_task://每日任务
                break;
            case R.id.iv_personal_center://个人中心
                startActivity(new Intent(this, PreActivity.class));
                overridePendingTransition(R.anim.pre_in, R.anim.pre_out);
                break;
        }
    }
}
