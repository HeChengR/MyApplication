package com.vxiaoxue.weiketang.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.vxiaoxue.weiketang.R;
import com.vxiaoxue.weiketang.adapter.GmAdapter;
import com.vxiaoxue.weiketang.adapter.MyViewHolder;
import com.vxiaoxue.weiketang.domain.WrongModal;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 我的错题本
 * Created by Administrator on 2015/8/19.
 */
public class WrongQuestionActivity extends BaseActivity {
    @InjectView(R.id.wrong_listView)
    ListView wrongListView;
    private List<WrongModal> WrongList = new ArrayList<>();
    private WrongModal info;
    private WrongAdapter wrongAdapter;
    private String[] grade = {"一年级", "二年级", "三年级", "四年级", "五年级", "六年级"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong_question);
        ButterKnife.inject(this);
        for (int index = 0; index < 6; index++) {
            info = new WrongModal();
            info.setGrade(grade[index]);
            info.setUnit("共10个单元" + index);
            info.setNumbers("20题");
            WrongList.add(info);
        }

        wrongAdapter = new WrongAdapter(this, WrongList, R.layout.wrong_item);
        wrongListView.setAdapter(wrongAdapter);

        wrongListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(WrongQuestionActivity.this, WrongQuestionSecondActivity.class));
            }
        });
    }

    public class WrongAdapter extends GmAdapter {
        public WrongAdapter(Context context, List mDatas, int itemLayoutId) {
            super(context, mDatas, itemLayoutId);
        }

        @Override
        public void convert(MyViewHolder helper, Object item, int position) {
            WrongModal wrongInfo = (WrongModal) item;
            helper.setText(R.id.tv_grade, wrongInfo.getGrade());//年级
            helper.setText(R.id.tv_unit, wrongInfo.getUnit());//单元
            helper.setText(R.id.tv_numbers, wrongInfo.getNumbers());//题目
        }
    }

}
