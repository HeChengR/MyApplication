package com.vxiaoxue.weiketang.domain;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2015/10/16.
 */
public class ShopModal {
    Drawable StoreImage;
    String StoreName;
    String StoreDes;
    String StorePrice;

    public Drawable getStoreImage() {
        return StoreImage;
    }

    public void setStoreImage(Drawable storeImage) {
        StoreImage = storeImage;
    }

    public String getStoreName() {
        return StoreName;
    }

    public void setStoreName(String storeName) {
        StoreName = storeName;
    }

    public String getStoreDes() {
        return StoreDes;
    }

    public void setStoreDes(String storeDes) {
        StoreDes = storeDes;
    }

    public String getStorePrice() {
        return StorePrice;
    }

    public void setStorePrice(String storePrice) {
        StorePrice = storePrice;
    }

}
