package com.vxiaoxue.weiketang.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

import com.vxiaoxue.weiketang.R;

/**
 * Created by Administrator on 2015/11/19.
 */
public class GoodDetailActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.good_item_des);
    }

    /**
     * 点击外部区域退出
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        finish();
        overridePendingTransition(R.anim.fade, R.anim.hold);
        return true;
    }
}
