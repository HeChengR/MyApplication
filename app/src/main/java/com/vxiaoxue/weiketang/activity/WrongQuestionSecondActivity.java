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
import com.vxiaoxue.weiketang.domain.WrongSecondModal;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 错题本二级页面
 * Created by Administrator on 2015/8/27.
 */
public class WrongQuestionSecondActivity extends BaseActivity {
    @InjectView(R.id.wrong_listView_second)
    ListView wrongListViewSecond;
    private List<WrongSecondModal> WrongSecondList;

    private WrongSecondModal wrongSecondInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong_question_second);
        ButterKnife.inject(this);
        initData();
        WrongSecondAdapter wrongSecondAdapter = new WrongSecondAdapter(this, WrongSecondList, R.layout.wrong_second_item);
        wrongListViewSecond.setAdapter(wrongSecondAdapter);
        wrongListViewSecond.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(WrongQuestionSecondActivity.this, WrongQuestionThreeActivity.class));
            }
        });
    }

    public void initData() {
        WrongSecondList = new ArrayList();
        for (int index = 0; index < 10; index++) {
            wrongSecondInfo = new WrongSecondModal();
            wrongSecondInfo.setUnit("一单元：名称" + index);
            wrongSecondInfo.setNumbers((int) (Math.random() * 10 + 1) + "题");
            WrongSecondList.add(wrongSecondInfo);
        }
    }

    public class WrongSecondAdapter extends GmAdapter {
        public WrongSecondAdapter(Context context, List mDatas, int itemLayoutId) {
            super(context, mDatas, itemLayoutId);
        }

        @Override
        public void convert(MyViewHolder helper, Object item,int position) {
            helper.setText(R.id.tv_unitName_second, ((WrongSecondModal) item).getUnit());
            helper.setText(R.id.tv_numbers_second, ((WrongSecondModal) item).getNumbers());
        }
    }
}
