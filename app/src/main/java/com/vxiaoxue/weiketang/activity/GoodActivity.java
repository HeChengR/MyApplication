package com.vxiaoxue.weiketang.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.vxiaoxue.weiketang.R;
import com.vxiaoxue.weiketang.fragment.ConsumableFragment;
import com.vxiaoxue.weiketang.fragment.CouponFragment;
import com.vxiaoxue.weiketang.fragment.PropFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 我的物品
 * Created by Administrator on 2015/8/19.
 */
public class GoodActivity extends Activity implements View.OnClickListener {
    @InjectView(R.id.good_shipProp)
    ImageButton goodShipProp;
    @InjectView(R.id.good_consumable)
    ImageButton goodConsumable;
    @InjectView(R.id.good_coupon)
    ImageButton goodCoupon;

    private Fragment prop, Consumable, Coupon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_good);
        ButterKnife.inject(this);
        initView();
        goodShipProp.setSelected(true);
        //设置默认的fragment
        prop = new PropFragment();
        setFragment(R.id.good_content, prop);
    }

    //返回
    public void onReturn(View v) {
        finish();
    }

    //进入设置页面
    public void onSet(View v) {

    }

    /**
     * 初始化视图
     */
    public void initView() {
        goodCoupon.setOnClickListener(this);
        goodShipProp.setOnClickListener(this);
        goodConsumable.setOnClickListener(this);
    }

    /**
     * fragment的管理类
     */
    public void setFragment(int fragment, Fragment newFragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(fragment, newFragment);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.good_consumable://消耗品
                goodConsumable.setSelected(true);
                goodCoupon.setSelected(false);
                goodShipProp.setSelected(false);
                Consumable = new ConsumableFragment();
                setFragment(R.id.good_content, Consumable);
                break;
            case R.id.good_coupon://优惠券
                goodConsumable.setSelected(false);
                goodCoupon.setSelected(true);
                goodShipProp.setSelected(false);
                Coupon = new CouponFragment();
                setFragment(R.id.good_content, Coupon);
                break;
            case R.id.good_shipProp://船只道具
                goodConsumable.setSelected(false);
                goodCoupon.setSelected(false);
                goodShipProp.setSelected(true);
                prop = new PropFragment();
                setFragment(R.id.good_content, prop);
                break;
        }
    }
}
