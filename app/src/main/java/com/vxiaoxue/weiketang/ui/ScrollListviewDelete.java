package com.vxiaoxue.weiketang.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

public class ScrollListviewDelete extends ListView {  
	  
    private float minDis = 10;  
    private float mLastMotionX;//记录上次X触摸屏的位置
    private float mLastMotionY;//记录上次Y触摸屏的位置
    private boolean isLock = false;  
  
    public ScrollListviewDelete(Context context, AttributeSet attrs) {  
        super(context, attrs);  
    }

    @Override  
    public boolean onInterceptTouchEvent(MotionEvent ev) {  
        if (!isIntercept(ev)) {  
            return false;  
        }  
        return super.onInterceptTouchEvent(ev);  
    }  
  
    @Override  
    public boolean dispatchTouchEvent(MotionEvent event) {  
        boolean dte = super.dispatchTouchEvent(event);  
        if (MotionEvent.ACTION_UP == event.getAction() && !dte) {//onItemClick  
            int position = pointToPosition((int)event.getX(), (int)event.getY());  
            View view = getChildAt(position);  
            super.performItemClick(view, position, view.getId());  
        }  
        return dte;  
    }  
  
    @Override
    public boolean performClick() {  
        return super.performClick();  
    }  
  
    @Override
    public boolean performItemClick(View view, int position, long id) {  
        return super.performItemClick(view, position, id);  
    }
    private boolean isIntercept(MotionEvent ev) {  
        float x = ev.getX();  
        float y = ev.getY();  
        int action = ev.getAction();  
        switch (action) {  
        case MotionEvent.ACTION_DOWN:
            mLastMotionX = x;  
            mLastMotionY = y;  
            break;  
        case MotionEvent.ACTION_MOVE:
            if (!isLock) {  
                float deltaX = Math.abs(mLastMotionX - x);  
                float deltay = Math.abs(mLastMotionY - y);  
                mLastMotionX = x;  
                mLastMotionY = y;  
                if (deltaX > deltay && deltaX > minDis) {  
                    isLock = true;  
                    return false;  
                }  
            } else {  
                return false;  
            }  
            break;  
        case MotionEvent.ACTION_UP:
            isLock = false;  
            break;  
        case MotionEvent.ACTION_CANCEL:
            isLock = false;  
            break;  
        }  
        return true;  
    }  
  
}  
