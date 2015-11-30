package com.vxiaoxue.weiketang.activity;

import android.os.Bundle;

import com.vxiaoxue.weiketang.R;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/8/24.
 */
public class FactionActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faction);
        ButterKnife.inject(this);
    }
}
