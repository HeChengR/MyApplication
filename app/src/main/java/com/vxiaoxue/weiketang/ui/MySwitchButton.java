package com.vxiaoxue.weiketang.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import com.vxiaoxue.weiketang.R;

/**
 * Created by Administrator on 2015/8/25.
 */
public class MySwitchButton extends View {
    private Bitmap mBitmapBreakground, mBitmapUP, mBitmapOFF;

    private int left = 0;

    private boolean isopen = true;

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
        mBitmapBreakground = BitmapFactory.decodeResource(getResources(), R.mipmap.system_setting_03);
        mBitmapUP = BitmapFactory.decodeResource(getResources(), R.mipmap.system_setting_07);
        mBitmapOFF = BitmapFactory.decodeResource(getResources(), R.mipmap.system_setting_10);
        left = mBitmapBreakground.getWidth() - mBitmapUP.getWidth();
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isopen) {
                    isopen = false;
                } else {
                    isopen = true;
                }
            }
        });
    }

    //绘制控件的大小
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(mBitmapBreakground.getWidth(), mBitmapBreakground.getHeight());
    }

    //画出开关的背景图片和需要显示的开、关图片
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mBitmapBreakground, 0, 0, null);
        if (isopen){
            canvas.drawBitmap(mBitmapUP, 5, 7, null);
        }else{
            canvas.drawBitmap(mBitmapOFF,left,7,null);
        }
    }
}
