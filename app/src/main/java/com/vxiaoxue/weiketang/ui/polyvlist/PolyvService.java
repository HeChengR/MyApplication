package com.vxiaoxue.weiketang.ui.polyvlist;

import android.content.Intent;

import com.easefun.polyvsdk.server.AndroidService;

/**
 * Created by Administrator on 2015/11/12.
 */
public class PolyvService extends AndroidService {

    public PolyvService() {
        super();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        flags = START_STICKY;
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        super.onHandleIntent(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
