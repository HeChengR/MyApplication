package com.vxiaoxue.weiketang.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.vxiaoxue.weiketang.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 我的收藏
 * Created by Administrator on 2015/8/19.
 */
public class CollectionActivity extends BaseActivity implements View.OnClickListener {


    @InjectView(R.id.collection_button)
    ImageView collectionButton;
    @InjectView(R.id.cache_button)
    ImageView cacheButton;

    private Fragment[] mFragments;//fragment数组
    private FragmentManager fragmentManager;//fragment管理者
    private FragmentTransaction fragmentTransaction;//fragment事务对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        ButterKnife.inject(this);
        initView();
        collectionButton.setSelected(true);
        setFragment();
    }

    /**
     * fragment的管理类
     */
    public void setFragment() {
        mFragments = new Fragment[2];
        fragmentManager = getFragmentManager();
        mFragments[0] = fragmentManager.findFragmentById(R.id.fragment_collection);
        mFragments[1] = fragmentManager.findFragmentById(R.id.fragment_cache);
        fragmentTransaction = fragmentManager.beginTransaction()
                .hide(mFragments[0]).hide(mFragments[1]);
        fragmentTransaction.show(mFragments[0]).commit();
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        collectionButton.setOnClickListener(this);
        cacheButton.setOnClickListener(this);
    }

    //返回
    public void onReturn(View v) {
        finish();
    }

    //进入设置页面
    public void onSet(View v) {
        startActivity(new Intent(this, SetActivity.class));
    }

    @Override
    public void onClick(View v) {
        fragmentTransaction = fragmentManager.beginTransaction()
                .hide(mFragments[0]).hide(mFragments[1]);
        switch (v.getId()) {
            case R.id.cache_button:
                collectionButton.setSelected(false);
                cacheButton.setSelected(true);
                fragmentTransaction.show(mFragments[1]).commit();
                break;
            case R.id.collection_button:
                collectionButton.setSelected(true);
                cacheButton.setSelected(false);
                fragmentTransaction.show(mFragments[0]).commit();
                break;

        }
    }
}
