package com.vxiaoxue.weiketang.activity;

import android.os.Bundle;

import com.vxiaoxue.weiketang.R;

import butterknife.ButterKnife;

/**
 * 我的里程碑
 * Created by Administrator on 2015/8/19.
 */
public class MilePostActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mile_post);
        ButterKnife.inject(this);
    }
}
