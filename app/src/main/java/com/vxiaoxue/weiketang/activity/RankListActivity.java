package com.vxiaoxue.weiketang.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.vxiaoxue.weiketang.R;

/**
 * 排行榜
 * Created by Administrator on 2015/8/19.
 */
public class RankListActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank_list);
    }
    //返回
    public void onReturn(View v) {
        finish();
    }

    //进入设置页面
    public void onSet(View v) {

    }
}
