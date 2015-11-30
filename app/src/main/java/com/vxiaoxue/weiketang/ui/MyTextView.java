package com.vxiaoxue.weiketang.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.vxiaoxue.weiketang.R;

/**
 * Created by Administrator on 2015/9/9.
 */
public class MyTextView extends TextView {
    private int NORMAL = 1;//默认字体
    private int SHOP = 3;//商城字体
    private int RANK = 2;//排行榜字体
    private Context mContext;

    public MyTextView(Context context) {
        super(context);
        mContext = context;
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MyTextView);

        int count = a.getIndexCount();
        for (int index = 0; index < count; index++) {
            int attr = a.getIndex(index);
            switch (attr) {
                case R.styleable.MyTextView_typeface:
                    NORMAL = a.getInteger(attr, 1);
                    SHOP = a.getInteger(attr, 3);
                    RANK = a.getInteger(attr, 2);
                    break;
            }
        }
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    public void setTypeface(Typeface tf) {
        super.setTypeface(tf);
        if (NORMAL == 1) {
            Typeface.createFromAsset(mContext.getAssets(), "font/ttf.TTF");
        } else if (RANK == 2) {
            Typeface.createFromAsset(mContext.getAssets(), "font/rank.ttf");
        } else if (SHOP == 3) {
            Typeface.createFromAsset(mContext.getAssets(), "font/shop.TTF");
        }
    }
}
