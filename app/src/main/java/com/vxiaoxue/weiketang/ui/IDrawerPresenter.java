package com.vxiaoxue.weiketang.ui;

/**
 * Created by Administrator on 2015/8/22.
 */
public interface IDrawerPresenter {
    IDrawerPresenter getInstance();
    void dispatchEvent(int totalPages, int currentPage);
}
