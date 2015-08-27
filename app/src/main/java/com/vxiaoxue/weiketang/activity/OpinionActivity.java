package com.vxiaoxue.weiketang.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.vxiaoxue.weiketang.R;

/**
 * 意见建议页面
 * Created by Administrator on 2015/8/24.
 */
public class OpinionActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opinion);
    }
    public void onReturn(View v){
        finish();
    }
}
