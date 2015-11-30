package com.vxiaoxue.weiketang.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.vxiaoxue.weiketang.R;
import com.vxiaoxue.weiketang.adapter.GmAdapter;
import com.vxiaoxue.weiketang.adapter.MyViewHolder;
import com.vxiaoxue.weiketang.domain.EventInfo;
import com.vxiaoxue.weiketang.ui.swipe.SwipeMenu;
import com.vxiaoxue.weiketang.ui.swipe.SwipeMenuCreator;
import com.vxiaoxue.weiketang.ui.swipe.SwipeMenuItem;
import com.vxiaoxue.weiketang.ui.swipe.SwipeMenuListView;
import com.vxiaoxue.weiketang.utils.DensityUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 航海大事记（系统公告）
 * Created by Administrator on 2015/8/19.
 */
public class NavigationEventActivity extends BaseActivity {

    @InjectView(R.id.event_list)
    SwipeMenuListView eventList;
  //  private ViewHolder mViewHolder;
    private ArrayList<EventInfo> list = new ArrayList<>();
    private EventInfo mEventInfo;

    private NavigationEventAdapter EventAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_event);
        ButterKnife.inject(this);
        initData();

        EventAdapter = new NavigationEventAdapter(this,list,R.layout.navigation_event_item);
        eventList.setAdapter(EventAdapter);
        //滑动删除
        SwipeMenuCreator createor = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                deleteItem.setBackground(R.color.red);
                deleteItem.setWidth(DensityUtil.dip2px(NavigationEventActivity.this, 50));
                deleteItem.setIcon(R.mipmap.ic_delete);
                menu.addMenuItem(deleteItem);
            }
        };
        eventList.setMenuCreator(createor);

        eventList.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClick(int position, SwipeMenu menu, int index) {
                list.remove(position);
                EventAdapter.notifyDataSetChanged();
            }
        });


        eventList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SwipeMenuListView listView = (SwipeMenuListView) parent;
                EventInfo list = (EventInfo) listView.getItemAtPosition(position);
                String title = list.getTitle();
                Intent EventIntent = new Intent(NavigationEventActivity.this, NavigationEventContentActivity.class);
                EventIntent.putExtra("title", title);
                startActivity(EventIntent);
            }
        });
    }
    //数据适配器
    class NavigationEventAdapter extends GmAdapter {
        public NavigationEventAdapter(Context context, List mDatas, int itemLayoutId) {
            super(context, mDatas, itemLayoutId);
        }

        @Override
        public void convert(MyViewHolder helper, Object item, int position) {
            EventInfo info = (EventInfo)item;
            helper.setImageResource(R.id.event_item_icon,info.getIcon());
            helper.setText(R.id.event_item_title, info.getTitle());
            helper.setText(R.id.event_item_date,info.getDate());
        }
    }
    //初始化展示数据
    public void initData() {
        for (int i = 0; i < 10; i++) {
            mEventInfo = new EventInfo();
            mEventInfo.setIcon(getResources().getDrawable(R.mipmap.myself_news_p02));
            mEventInfo.setTitle("微课糖新大陆火热进行中" + i);
            mEventInfo.setDate("2015-8-20");
            list.add(mEventInfo);
        }
    }
}
