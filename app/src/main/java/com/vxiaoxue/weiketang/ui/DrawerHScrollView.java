package com.vxiaoxue.weiketang.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

import java.util.Hashtable;

/**
 * Created by Administrator on 2015/8/22.
 */
public class DrawerHScrollView extends HorizontalScrollView {
    private int totalPage = 1;
    private int currentPage = 0;
    private int ScrollDisx;
    //根据页数存放位置信息，页数越多，存放的值越大
    private Hashtable<Integer, Integer> PositionPages = new Hashtable<>();

    private IDrawerPresenter iDrawerPresenter;

    public DrawerHScrollView(Context context) {
        super(context);
    }

    public DrawerHScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public DrawerHScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 给HorizontalScrollView设置参数的方法
     *
     * @param totalPage   总的页数
     * @param currentPage 当前的页数
     * @param ScrollDisX  显示的宽度   HorizontalScrollView的宽度减去空白区域的宽度
     */
    public void setParameters(int totalPage, int currentPage, int ScrollDisX) {
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.ScrollDisx = ScrollDisX;
        PositionPages.clear();
        for (int i = 0; i < totalPage; i++) {
            int ScrollX = (ScrollDisX) * i;
            PositionPages.put(i, ScrollX);
        }
        smoothScrollTo(0, 0);
    }

    //如果当前总页数为1，当前页为0,且集合不为空的话就将集合清空
    public void cleanUp() {
        totalPage = 1;
        currentPage = 0;
        if (PositionPages != null) {
            PositionPages.clear();
        }
    }

    public void setPresenter(IDrawerPresenter iDrawerPresenter) {
        this.iDrawerPresenter = iDrawerPresenter;
    }
    //滑动
    @Override
    public void fling(int velocityX) {
        boolean change_flag = false;
        //向右边滑动
        if (velocityX > 0 && (currentPage < totalPage - 1)) {
            currentPage++;
            change_flag = true;
            //向左边滑动
        } else if (velocityX < 0 && (currentPage > 0)) {
            currentPage--;
            change_flag = true;
        }
        if (change_flag) {
            int position = PositionPages.get(new Integer(currentPage)).intValue();
            smoothScrollTo(position, 0);
            iDrawerPresenter.dispatchEvent(totalPage, currentPage);
        }
    }

}
