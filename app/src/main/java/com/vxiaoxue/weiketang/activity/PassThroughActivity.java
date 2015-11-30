package com.vxiaoxue.weiketang.activity;

import android.app.Activity;
import android.os.Bundle;

import com.vxiaoxue.weiketang.R;

/**
 * Created by Administrator on 2015/11/30.
 */
public class PassThroughActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pass_through_activity);
    }
}
