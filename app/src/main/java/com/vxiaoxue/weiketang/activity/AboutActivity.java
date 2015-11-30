package com.vxiaoxue.weiketang.activity;

import android.os.Bundle;

import com.vxiaoxue.weiketang.R;

import butterknife.ButterKnife;

/**
 * 关于我们页面
 * Created by Administrator on 2015/8/24.
 */
public class AboutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.inject(this);
    }
}
