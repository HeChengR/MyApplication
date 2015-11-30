package com.vxiaoxue.weiketang.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/**
 * Created by Administrator on 2015/9/17.
 */
public class MyPopUpWindow extends PopupWindow{
    private LayoutInflater inflater;
    private View mMenuView;
    public MyPopUpWindow(Context context){
        inflater = LayoutInflater.from(context);
    }
    /**
     * 设置POP的参数信息
     * @param PopView
     */
    public void setLayoutParams(int PopView){
        mMenuView = inflater.inflate(PopView, null);
        this.setContentView(mMenuView);
        this.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setFocusable(true);//获取焦点
        this.setBackgroundDrawable(new BitmapDrawable());//设置PopupWindow的背景为一个空的Drawable对象，如果不设置这个，那么PopupWindow弹出后就无法退出了
        this.setOutsideTouchable(true);//设置是否点击PopupWindow外退出PopupWindow

    }
    /**
     * 用于获取POP的View对象
     * @return
     */
    public View getmMenuView(){
        return mMenuView;
    }
}
