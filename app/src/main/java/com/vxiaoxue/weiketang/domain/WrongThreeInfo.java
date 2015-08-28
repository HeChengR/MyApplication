package com.vxiaoxue.weiketang.domain;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2015/8/27.
 */
public class WrongThreeInfo {
    private String name;//年级
    private String time;//单元
    private Drawable icon;//题数

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
