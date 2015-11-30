package com.vxiaoxue.weiketang.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.vxiaoxue.weiketang.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 我的收藏
 * Created by Administrator on 2015/8/19.
 */
public class CollectionActivity extends BaseActivity implements View.OnClickListener {
    @InjectView(R.id.collection_button)
    RadioButton collectionButton;
    @InjectView(R.id.cache_button)
    RadioButton cacheButton;
    private Fragment[] mFragments;//fragment数组
    private FragmentManager fragmentManager;//fragment管理者
    private FragmentTransaction fragmentTransaction;//fragment事务对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        ButterKnife.inject(this);

        initViews();
        setFragment();
    }

    public void initViews(){
        collectionButton.setOnClickListener(this);
        cacheButton.setOnClickListener(this);
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
    public void onClick(View v) {
        fragmentTransaction = fragmentManager.beginTransaction()
                .hide(mFragments[0]).hide(mFragments[1]);
        switch (v.getId()) {
            case R.id.cache_button:
                fragmentTransaction.show(mFragments[1]).commit();
                break;
            case R.id.collection_button:
                fragmentTransaction.show(mFragments[0]).commit();
                break;

        }
    }
}
