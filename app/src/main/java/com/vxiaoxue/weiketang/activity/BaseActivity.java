package com.vxiaoxue.weiketang.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.vxiaoxue.weiketang.R;

/**
 * 页面的基类
 * Created by Administrator on 2015/8/21.
 */
public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //设置全屏显示
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
    }
    /**
     * 返回到上一页
     *
     * @param v
     */
    public void onReturn(View v) {
        finish();
        overridePendingTransition(R.anim.fade,R.anim.hold);
    }

    /**
     * 进去到设置页面
     *
     * @param v
     */
    public void onSet(View v) {
        startActivity(new Intent(this, SetActivity.class));
    }
}
