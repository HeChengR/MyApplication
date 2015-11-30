package com.vxiaoxue.weiketang.ui.font;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;

import java.util.Hashtable;


/**
 * Created by Administrator on 2015/11/17.
 */
public final class MagicFont {
    private Context mContext;
    private AssetManager am;
    private String fontFolderPath = null;
    private final Hashtable<String, Typeface> fonts = new Hashtable<>();

    private MagicFont() {
    }

    private MagicFont(Context context) {
        mContext = context;
    }

    private volatile static MagicFont magicFont;

    public static MagicFont getInstance(Context context) {
        if (magicFont == null) {
            synchronized (MagicFont.class) {
                if (magicFont == null) {
                    magicFont = new MagicFont(context);
                }
            }
        }
        return magicFont;
    }

    /**
     * @param typeface typeface to set
     */
    private void initializeFont(String typeface) {

        am = mContext.getResources().getAssets();

        String fontPath = fontFolderPath + "/" + typeface;
        System.out.print(fontPath);
        fontPath = fontPath.replaceAll("//", "/");
        if (fontPath.startsWith("/")) {
            fontPath = fontPath.substring(1, fontPath.length());
        }
        Typeface font = Typeface.createFromAsset(am, fontPath);
        fonts.put(typeface, font);

    }

    /**
     * Returns requested typeface. If this class is not initialized it will try to initialize it and return
     * requested font
     */
    public Typeface getTypeface(Context ctx, String typeface) {
        if (fontFolderPath == null || fontFolderPath.isEmpty()) {
            throw new MagicViewsNotInitializedException("Font folder path is empty. " +
                    "Have you called MagicViews.setFontFolderPath in your application class?");
        }
        if (!fonts.containsKey(typeface)) {
            MagicFont.getInstance(ctx).initializeFont(typeface);
        }
        return fonts.get(typeface);
    }

    public void setMagicFontsPath(String Path) {
        this.fontFolderPath = Path;
    }
}
