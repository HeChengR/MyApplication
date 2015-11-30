package com.vxiaoxue.weiketang.domain;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2015/8/27.
 */
public class CollectionInfo {
    private Drawable IBackground;//背景图
    private String CourseName;//课程名
    private String CourseDes;//课程描述

    public Drawable getIBackground() {
        return IBackground;
    }

    public void setIBackground(Drawable IBackground) {
        this.IBackground = IBackground;
    }

    public String getCourseName() {
        return CourseName;
    }
    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getCourseDes() {
        return CourseDes;
    }

    public void setCourseDes(String courseDes) {
        CourseDes = courseDes;
    }
}
