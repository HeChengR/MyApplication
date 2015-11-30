package com.vxiaoxue.weiketang.ui.font;

import android.content.Context;

/**
 * 获取到字体的路径
 * Created by Administrator on 2015/11/16.
 */
public class MagicView {
    public static void setFontsPath(Context ctx,String FontsPath){
        MagicFont.getInstance(ctx).setMagicFontsPath(FontsPath);
    }
}
