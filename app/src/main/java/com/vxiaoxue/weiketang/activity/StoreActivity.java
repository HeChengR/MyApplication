package com.vxiaoxue.weiketang.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v17.leanback.widget.HorizontalGridView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.vxiaoxue.weiketang.R;
import com.vxiaoxue.weiketang.adapter.RecyclerAdapter;
import com.vxiaoxue.weiketang.domain.ShopModal;
import com.vxiaoxue.weiketang.utils.DensityUtil;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2015/9/9.
 */
public class StoreActivity extends Activity implements View.OnClickListener {
    @InjectView(R.id.shop_return)
    ImageButton shopReturn;
    @InjectView(R.id.Shop_hgv)
    HorizontalGridView ShopHgv;
    @InjectView(R.id.mImageButton_prop)
    RadioButton mImageButtonProp;
    @InjectView(R.id.mImageButton_consumables)
    RadioButton mImageButtonConsumables;
    @InjectView(R.id.mImageButton_coupons)
    RadioButton mImageButtonCoupons;
    private ArrayList<ShopModal> ShopList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_shop);
        ButterKnife.inject(this);
        initViews();
        initData();
        ShopHgv.setAdapter(new StoreAdapter(this, R.layout.shop_item, ShopList));
        ShopHgv.setItemMargin(DensityUtil.px2dip(this, 21));
    }

    public void initViews() {
        shopReturn.setOnClickListener(this);
        mImageButtonProp.setOnClickListener(this);
        mImageButtonConsumables.setOnClickListener(this);
        mImageButtonCoupons.setOnClickListener(this);
    }

    private void initData() {
        ShopList = new ArrayList<>();
        for (int index = 0; index < 20; index++) {
            ShopModal modal = new ShopModal();
            modal.setStoreImage(getResources().getDrawable(R.mipmap.store_pic01));
            modal.setStoreName("金身" + index);
            modal.setStoreDes("强化船身防御力" + index);
            modal.setStorePrice("800");
            ShopList.add(modal);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shop_return:
                finish();
                overridePendingTransition(R.anim.fade, R.anim.hold);
                break;
            case R.id.mImageButton_prop:

                break;
            case R.id.mImageButton_consumables:

                break;
            case R.id.mImageButton_coupons:

                break;
        }
    }

    class StoreAdapter extends RecyclerAdapter {

        public StoreAdapter(Context context, int ViewId, ArrayList mImgIds) {
            super(context, ViewId, mImgIds);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ShopModal modal = ShopList.get(position);
            ViewHolder viewHolder = (ViewHolder) holder;
            ImageView shop_item_img = (ImageView) viewHolder.itemView.findViewById(R.id.shop_item_img);
            TextView shop_item_name = (TextView) viewHolder.itemView.findViewById(R.id.shop_item_name);
            TextView shop_item_des = (TextView) viewHolder.itemView.findViewById(R.id.shop_item_des);
            TextView shop_item_money = (TextView) viewHolder.itemView.findViewById(R.id.shop_item_money);
            shop_item_img.setImageDrawable(modal.getStoreImage());
            shop_item_name.setText(modal.getStoreName());
            shop_item_des.setText(modal.getStoreDes());
            shop_item_money.setText(modal.getStorePrice());
        }
    }
}
