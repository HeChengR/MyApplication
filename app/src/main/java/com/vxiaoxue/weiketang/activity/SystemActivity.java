package com.vxiaoxue.weiketang.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.vxiaoxue.weiketang.R;
import com.vxiaoxue.weiketang.ui.MySwitchButton;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2015/8/24.
 */
public class SystemActivity extends BaseActivity implements MySwitchButton.OnChangeButtonStateListener {

    @InjectView(R.id.wifi_user)
    MySwitchButton wifiUser;
    @InjectView(R.id.wifi_load)
    MySwitchButton wifiLoad;
    @InjectView(R.id.cache_notice)
    MySwitchButton cacheNotice;
    @InjectView(R.id.message_push)
    MySwitchButton messagePush;
    @InjectView(R.id.message_notice)
    MySwitchButton messageNotice;
    @InjectView(R.id.delete_cache)
    ImageView deleteCache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system);
        ButterKnife.inject(this);
//
//        wifiUser.setOnChangeButtonStateListener(new MySwitchButton.OnChangeButtonStateListener() {
//            @Override
//            public void ButtonState(boolean isOpen) {
//                if (isOpen){
//                    Toast.makeText(SystemActivity.this,"开关已开启",Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(SystemActivity.this,"开关已关闭",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        wifiUser.setOnChangeButtonStateListener(this);
        wifiLoad.setOnChangeButtonStateListener(this);
        cacheNotice.setOnChangeButtonStateListener(this);
        messageNotice.setOnChangeButtonStateListener(this);
        messagePush.setOnChangeButtonStateListener(this);
    }

    @Override
    public void ButtonState(boolean isOpen) {
        if (isOpen) {
            Toast.makeText(SystemActivity.this, "开关已开启", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(SystemActivity.this, "开关已关闭", Toast.LENGTH_SHORT).show();
        }
    }
}
