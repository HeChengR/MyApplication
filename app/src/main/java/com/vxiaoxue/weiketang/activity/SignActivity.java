package com.vxiaoxue.weiketang.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vxiaoxue.weiketang.R;
import com.vxiaoxue.weiketang.utils.ToastUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 签到页面
 * Created by Administrator on 2015/10/19.
 */
public class SignActivity extends Activity implements View.OnClickListener {
    @InjectView(R.id.sign_get)
    ImageView signGet;
    @InjectView(R.id.sign_return)
    ImageView signReturn;
    @InjectView(R.id.sign_days)
    LinearLayout signDays;
    @InjectView(R.id.sign_click_layout)
    RelativeLayout signClickLayout;

    private String[] SignDay = {"第一天", "第二天", "第三天", "第四天"};
    private int[] SignImage = new int[]{R.mipmap.person_sign_03_13, R.mipmap.person_sign_03_15, R.mipmap.person_sign_03_17,
            R.mipmap.person_sign_03_19};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign);
        ButterKnife.inject(this);
        initViews();
    }

    public void initViews() {
        for (int index = 0; index < 4; index++) {
            View SignView = View.inflate(this, R.layout.sign_item, null);
            ImageView mImageViewSign = (ImageView) SignView.findViewById(R.id.ImageView_sign);
            TextView mTextViewDays = (TextView) SignView.findViewById(R.id.TextView_days);
            final LinearLayout SignLayout = (LinearLayout) SignView.findViewById(R.id.sign_layout);
            mImageViewSign.setImageResource(SignImage[index]);
            mTextViewDays.setText(SignDay[index]);
            SignLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SignLayout.setBackgroundResource(R.mipmap.person_sign_02_13);
                    startActivity(new Intent(SignActivity.this, SignContentActivity.class));
                }
            });
            signDays.addView(SignView);
        }

        signReturn.setOnClickListener(this);
        signGet.setOnClickListener(this);

        signClickLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_return://退出签到页面
                finish();
                overridePendingTransition(R.anim.fade, R.anim.hold);
                break;
            case R.id.sign_get://获取签到的奖励
                ToastUtils.show(SignActivity.this, "获取成功", Toast.LENGTH_SHORT);
                break;
            case R.id.sign_click_layout:
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        finish();
        overridePendingTransition(R.anim.fade, R.anim.hold);
        return true;
    }

    //退出当前页面（退出动画）
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            overridePendingTransition(R.anim.fade, R.anim.hold);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
