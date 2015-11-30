package com.vxiaoxue.weiketang.activity;

import android.content.Context;
import android.os.Bundle;

import com.vxiaoxue.weiketang.R;
import com.vxiaoxue.weiketang.adapter.GmAdapter;
import com.vxiaoxue.weiketang.adapter.MyViewHolder;
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
 * 系统设置 --消费记录页面
 * Created by Administrator on 2015/8/24.
 */
public class RecordActivity extends BaseActivity {
    @InjectView(R.id.record_listViewDelete)
    SwipeMenuListView recordListViewDelete;


    private ConsumptionInfo consumptionInfo;
    private ArrayList list = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        ButterKnife.inject(this);
        initData();

        final Consumption consumptionAdapter = new Consumption(this, list, R.layout.consumption_record_item);
        recordListViewDelete.setAdapter(consumptionAdapter);

        SwipeMenuCreator createor = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                deleteItem.setBackground(R.color.red);
                deleteItem.setWidth(DensityUtil.dip2px(RecordActivity.this, 50));
                deleteItem.setIcon(R.mipmap.ic_delete);
                menu.addMenuItem(deleteItem);
            }
        };

        recordListViewDelete.setMenuCreator(createor);

        recordListViewDelete.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClick(int position, SwipeMenu menu, int index) {
                list.remove(position);
                consumptionAdapter.notifyDataSetChanged();
            }
        });
    }

    public void initData() {
        for (int index = 0; index < 10; index++) {
            consumptionInfo = new ConsumptionInfo();
            consumptionInfo.setDes("哈哈哈" + index);
            consumptionInfo.setTime("2015-05-12");
            list.add(consumptionInfo);
        }
    }

    public class Consumption extends GmAdapter {
        public Consumption(Context context, List mDatas, int itemLayoutId) {
            super(context, mDatas, itemLayoutId);
        }

        @Override
        public void convert(MyViewHolder helper, Object item,int position) {
            ConsumptionInfo info = (ConsumptionInfo) item;
            helper.setText(R.id.tv_consumption_des, info.getDes());
            helper.setText(R.id.tv_consumption_time, info.getTime());
        }
    }

    public class ConsumptionInfo {
        private String des;
        private String time;

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
