package com.vxiaoxue.weiketang.ui.font;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/11/16.
 */
public class TextViewMagic extends TextView {
    public TextViewMagic(Context context) {
        super(context);
        init(context, null);
    }

    public TextViewMagic(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            init(context, attrs);
        }
    }

    public TextViewMagic(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode()) {
            init(context, attrs);
        }
    }

    public void init(Context context, AttributeSet attrs) {
        FontUtils.setTypeface(context, attrs, this);
    }
}
