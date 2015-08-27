package com.vxiaoxue.weiketang.domain;

import android.graphics.drawable.Drawable;

/**
 * 航海大事记数据封装类
 * Created by Administrator on 2015/8/20.
 */
public class EventInfo {
    private Drawable icon;
    private String title;
    private String date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}
