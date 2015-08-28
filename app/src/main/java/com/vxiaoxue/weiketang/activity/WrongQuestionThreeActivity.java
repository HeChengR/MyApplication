package com.vxiaoxue.weiketang.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vxiaoxue.weiketang.R;
import com.vxiaoxue.weiketang.domain.WrongThreeInfo;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2015/8/27.
 */
public class WrongQuestionThreeActivity extends Activity {
    @InjectView(R.id.wrong_listView_three)
    ExpandableListView wrongListViewThree;

    private ArrayList<WrongThreeInfo> list = new ArrayList<>();
    private WrongThreeInfo wrongThreeInfo;
    private MyExpandableAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong_question_three);
        ButterKnife.inject(this);
        initData();

        adapter = new MyExpandableAdapter();
        wrongListViewThree.setAdapter(adapter);
        wrongListViewThree.setGroupIndicator(null);
    }

    //返回
    public void onReturn(View v) {
        finish();
    }
    public void initData() {
        for (int index = 0; index < 7; index++) {
            wrongThreeInfo = new WrongThreeInfo();
            wrongThreeInfo.setName("一元一次方程：点击进入详情页面" + index);
            wrongThreeInfo.setTime("2015-08-08");
            wrongThreeInfo.setIcon(getResources().getDrawable(R.mipmap.remove_button_03));
            list.add(wrongThreeInfo);
        }
    }

    class MyExpandableAdapter extends BaseExpandableListAdapter {
        @Override
        public int getGroupCount() {
            return list.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return 1;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return null;
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return null;
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            convertView = View.inflate(WrongQuestionThreeActivity.this, R.layout.wrong_three_item, null);
            TextView tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            TextView tv_time3 = (TextView) convertView.findViewById(R.id.tv_time);
            ImageView iv_remove = (ImageView) convertView.findViewById(R.id.iv_remove);
            tv_name.setText(list.get(groupPosition).getName());
            tv_time3.setText(list.get(groupPosition).getTime());
            iv_remove.setImageDrawable(list.get(groupPosition).getIcon());
            //点击删除
            iv_remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.remove(groupPosition);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(WrongQuestionThreeActivity.this, "已移除第" + (groupPosition + 1) + "个", Toast.LENGTH_SHORT).show();
                }
            });
            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            TextView textView = new TextView(getApplication());
            textView.setText("我是什么?");
            return textView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return false;
        }
    }
}
