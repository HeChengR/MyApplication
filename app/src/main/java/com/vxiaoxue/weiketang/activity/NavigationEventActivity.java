package com.vxiaoxue.weiketang.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.vxiaoxue.weiketang.R;
import com.vxiaoxue.weiketang.adapter.ListViewAdapter;
import com.vxiaoxue.weiketang.adapter.ViewHolder;
import com.vxiaoxue.weiketang.domain.EventInfo;
import com.vxiaoxue.weiketang.ui.ScrollListviewDelete;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 航海大事记
 * Created by Administrator on 2015/8/19.
 */
public class NavigationEventActivity extends Activity {
    @InjectView(R.id.event_list)
    ScrollListviewDelete eventList;

    private ArrayList<EventInfo> list = new ArrayList<>();
    private EventInfo mEventInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_event);
        ButterKnife.inject(this);

        initAdapter();
        initData();
    }

    //返回
    public void onReturn(View v) {
        finish();
    }

    //进入设置页面
    public void onSet(View v) {

    }
    //数据适配器类
    public void initAdapter() {
        eventList.setAdapter(new ListViewAdapter<EventInfo>(this,list,R.layout.navigation_event_item) {
            @Override
            public void convert(ViewHolder helper, final EventInfo item) {
                  helper.setImageResource(R.id.event_item_icon, item.getIcon());
                  helper.setText(R.id.event_item_title, item.getTitle());
                  helper.setText(R.id.event_item_date, item.getDate());
                 View view = helper.getConvertView();
                Button event_delete = (Button)view.findViewById(R.id.event_delete);
                event_delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        list.remove(item);
                        notifyDataSetChanged();
                    }
                });
            }
        });
    }

    //初始化展示数据
    public void initData() {
        for (int i = 0; i < 10; i++) {
            mEventInfo = new EventInfo();
            mEventInfo.setIcon(getResources().getDrawable(R.mipmap.myself_news_p02));
            mEventInfo.setTitle("微课糖新大陆火热进行中"+i);
            mEventInfo.setDate("2015-8-20");
            list.add(mEventInfo);
        }
    }
}
