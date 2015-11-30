package com.vxiaoxue.weiketang.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.vxiaoxue.weiketang.R;
import com.vxiaoxue.weiketang.domain.WrongThreeModal;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2015/8/27.
 */
public class WrongQuestionThreeActivity extends BaseActivity {

    @InjectView(R.id.wrong_listView_three)
    ExpandableListView wrongListViewThree;
    private ArrayList<WrongThreeModal> list = new ArrayList<>();
    private WrongThreeModal wrongThreeInfo;
    private MyExpandableAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong_question_three);
        ButterKnife.inject(this);
        initData();
        adapter = new MyExpandableAdapter();
        wrongListViewThree.setAdapter(adapter);
        wrongListViewThree.setGroupIndicator(null);//去掉箭头
    }

    public void initData() {
        for (int index = 0; index < 7; index++) {
            wrongThreeInfo = new WrongThreeModal();
            wrongThreeInfo.setName("一元一次方程：点击进入详情页面" + index);
            wrongThreeInfo.setTime("2015-08-08");
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
            tv_name.setText(list.get(groupPosition).getName());
            tv_time3.setText(list.get(groupPosition).getTime());
            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(WrongQuestionThreeActivity.this).inflate(R.layout.wrong_three_seconditem, null);
           ScrollView wrong_parse = (ScrollView)view.findViewById(R.id.wrong_parse);
            wrong_parse.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return true;
                }
            });
            return view;
        }
        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return false;
        }
    }


}
