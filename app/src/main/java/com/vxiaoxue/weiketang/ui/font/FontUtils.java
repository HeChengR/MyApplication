package com.vxiaoxue.weiketang.ui.font;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import com.vxiaoxue.weiketang.R;
/**
 * Created by ivankocijan on 18.05.2014..
 */
public class FontUtils {

    /**
     * @param ctx
     * @param attrs
     * @param view
     */
    public static void setTypeface(Context ctx, AttributeSet attrs, TextView view) {

        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.MagicFont);
        String fontStyle = a.getString(R.styleable.MagicFont_typeFace);

        if (fontStyle != null) {
            view.setTypeface(MagicFont.getInstance(ctx).getTypeface(ctx, fontStyle));
        }
        a.recycle();
    }
}
