package com.vxiaoxue.weiketang.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vxiaoxue.weiketang.R;

/**
 * 船只道具Fragment管理类
 * Created by Administrator on 2015/8/19.
 */
public class PropFragment extends Fragment {
    private ViewPager propViewpager;
    private PropViewPager VPAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //转化为View对象
        View view = inflater.inflate(R.layout.prop_fragment, container);
        //拿到ViewPager,给ViewPager设置适配器
        propViewpager = (ViewPager) view.findViewById(R.id.prop_viewpager);
        setViewPager();
        return view;
    }

    public void setViewPager() {
        VPAdapter = new PropViewPager();
        propViewpager.setAdapter(VPAdapter);
    }

    public class PropViewPager extends PagerAdapter {

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView tv = new TextView(getActivity());
            tv.setText("ahah");
            TextView tv1 = new TextView(getActivity());
            tv.setText("哈哈");
            TextView tv2 = new TextView(getActivity());
            tv.setText("呵呵");
            TextView tv3 = new TextView(getActivity());
            tv.setText("嘻嘻");
            container.addView(tv);
            container.addView(tv1);
            container.addView(tv2);
            container.addView(tv3);
            return position;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }
    }
}
