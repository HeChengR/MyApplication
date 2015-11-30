package com.vxiaoxue.weiketang.domain;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2015/9/2.
 */
public class RankModal {
    private Drawable icon;
    private String name;
    private String title;
    private String number;

    public RankModal() {
    }

    public RankModal(Drawable icon, String name, String title, String number) {
        this.icon = icon;
        this.name = name;
        this.title = title;
        this.number = number;
    }
    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


}
