package com.vxiaoxue.weiketang.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.vxiaoxue.weiketang.R;

/**
 * 开关按钮，点击空白区域显示开关状态
 * Created by Administrator on 2015/8/25.
 */
public class MySwitchButton extends View {
    private Bitmap mBitmapBreakGround, mBitmapUP, mBitmapOFF;

    private int Middle;//中间位置的坐标

    private int BreakGroundWidth = 0;//背景的宽度
    private int BitmapUP = 0;//开的时候状态的宽度

    private OnChangeButtonStateListener ChangeButtonState;

    private boolean isOpen = true;

    public MySwitchButton(Context context) {
        super(context);
        init();
    }

    public MySwitchButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MySwitchButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    //初始化图片
    public void init() {
        mBitmapBreakGround = BitmapFactory.decodeResource(getResources(), R.mipmap.system_setting_03);//背景图
        mBitmapUP = BitmapFactory.decodeResource(getResources(), R.mipmap.system_setting_07);//开
        mBitmapOFF = BitmapFactory.decodeResource(getResources(), R.mipmap.system_setting_10);//关


        BreakGroundWidth = mBitmapBreakGround.getWidth();
        BitmapUP = mBitmapUP.getWidth();
        Middle = BreakGroundWidth - BitmapUP;
    }

    //绘制控件的大小
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(mBitmapBreakGround.getWidth(), mBitmapBreakGround.getHeight());
    }

    //画出开关的背景图片和需要显示的开、关图片
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mBitmapBreakGround, 0, 0, null);
        if (isOpen) {
            canvas.drawBitmap(mBitmapUP, 3, 7, null);
        } else {
            canvas.drawBitmap(mBitmapOFF, Middle, 7, null);
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN://按下
                int CurrentX = (int) event.getX();//按下时的X坐标
                if (CurrentX < Middle) {
                    isOpen = true;
                    ChangeButtonState.ButtonState(isOpen);
                } else {
                    isOpen = false;
                    ChangeButtonState.ButtonState(isOpen);
                }
                break;
            case MotionEvent.ACTION_MOVE://移动
                break;
            case MotionEvent.ACTION_UP://抬起

                break;

        }
        invalidate();
        return true;
    }

    //设置回调监听、将当前按钮的状态回调
    public void setOnChangeButtonStateListener(OnChangeButtonStateListener ChangeButtonState) {
        this.ChangeButtonState = ChangeButtonState;
    }
    public interface OnChangeButtonStateListener {
        void ButtonState(boolean isOpen);
    }
}
