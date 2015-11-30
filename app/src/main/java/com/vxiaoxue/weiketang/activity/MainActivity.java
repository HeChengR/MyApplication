package com.vxiaoxue.weiketang.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.vxiaoxue.weiketang.R;
import com.vxiaoxue.weiketang.ui.font.TextViewMagic;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    @InjectView(R.id.iv_head_port)
    ImageView ivHeadPort;
    @InjectView(R.id.user_name)
    TextViewMagic userName;
    @InjectView(R.id.tv_progress_name)
    TextViewMagic tvProgressName;
    @InjectView(R.id.iv_progress)
    RelativeLayout ivProgress;
    @InjectView(R.id.medal_1)
    ImageView medal1;
    @InjectView(R.id.medal_2)
    ImageView medal2;
    @InjectView(R.id.medal_3)
    ImageView medal3;
    @InjectView(R.id.see_medal)
    TextViewMagic seeMedal;
    @InjectView(R.id.personal_data)
    ImageButton personalData;
    @InjectView(R.id.iv_chart)
    ImageButton ivChart;
    @InjectView(R.id.iv_personal_center)
    ImageButton ivPersonalCenter;
    @InjectView(R.id.iv_task)
    ImageButton ivTask;
    @InjectView(R.id.iv_shop)
    ImageButton ivShop;
    @InjectView(R.id.iv_attendance)
    ImageButton ivAttendance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        setContentView(R.layout.activity_main);
        // 去除手机虚拟按键，加上此功能之后会导致五大模块按键不灵活（第一次点击获取焦点，第二次点击才真正的开启页面）.
        // enterLightsOutMode(getWindow());
        ButterKnife.inject(this);
        initViews();
    }

    //初始化视图监听器
    private void initViews() {
        ivAttendance.setOnClickListener(this);
        ivChart.setOnClickListener(this);
        ivPersonalCenter.setOnClickListener(this);
        ivTask.setOnClickListener(this);
        ivShop.setOnClickListener(this);
        personalData.setOnClickListener(this);
    }

    //点击进入相关的页面
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_attendance://签到
                startActivity(new Intent(this, SignActivity.class));
                overridePendingTransition(R.anim.fade, R.anim.hold);
                break;
            case R.id.iv_chart://起航
                startActivity(new Intent(this, ChartActivity.class));
                break;
            case R.id.iv_shop://商城
                startActivity(new Intent(this, StoreActivity.class));
                overridePendingTransition(R.anim.fade, R.anim.hold);
                break;
            case R.id.iv_task://每日任务
                break;
            case R.id.iv_personal_center://个人中心
                startActivity(new Intent(this, PreActivity.class));
                overridePendingTransition(R.anim.fade, R.anim.hold);
                break;
            case R.id.personal_data://个人形象页面
                startActivity(new Intent(this, FigureActivity.class));
                overridePendingTransition(R.anim.fade, R.anim.hold);
                break;
        }
    }

    //去除虚拟按键,手机屏幕获取焦点之后虚拟按键还会显示(这是一个问题).
    public static void enterLightsOutMode(Window window) {
        WindowManager.LayoutParams params = window.getAttributes();
        params.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        window.setAttributes(params);
    }
}
