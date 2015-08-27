package com.vxiaoxue.weiketang.activity;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 2015/8/21.
 */
public abstract class BaseActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public abstract void initData();


    public abstract void initView();
}
