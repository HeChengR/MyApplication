package com.vxiaoxue.weiketang.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.vxiaoxue.weiketang.R;
import com.vxiaoxue.weiketang.ui.polyvlist.VideoListActivity;

/**
 * Created by Administrator on 2015/8/31.
 */
public class ChartActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_chart);
    }

    public void onVideo(View v){
        //跳转到视频播放列表页面
        Intent intent = new Intent(this,VideoListActivity.class);
        startActivity(intent);
    }
}
