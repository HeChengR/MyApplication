package com.vxiaoxue.weiketang.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import com.vxiaoxue.weiketang.R;
import com.vxiaoxue.weiketang.adapter.ListViewAdapter;
import com.vxiaoxue.weiketang.adapter.ViewHolder;
import com.vxiaoxue.weiketang.domain.WrongInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 我的错题本
 * Created by Administrator on 2015/8/19.
 */
public class WrongQuestionActivity extends Activity {
    @InjectView(R.id.wrong_listView)
    ListView wrongListView;

    private List<WrongInfo> WrongList = new ArrayList<>();
    private WrongInfo info = new WrongInfo();
    private WrongAdapter wrongAdapter;
    private String[] grade = {"一年级", "二年级", "三年级", "四年级", "五年级", "六年级"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong_question);
        ButterKnife.inject(this);

        for (int index = 0;index < 6;index++){
            info.setGrade(grade[index]);
            info.setUnit("共10个单元"+index);
            info.setNumbers("20题");
            WrongList.add(info);
        }

        wrongAdapter = new WrongAdapter(this,WrongList,R.layout.wrong_item);
        wrongListView.setAdapter(wrongAdapter);

        wrongListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  startActivity(new Intent(WrongQuestionActivity.this,WrongQuestionSecondActivity.class));
            }
        });
    }

    //返回
    public void onReturn(View v) {
        finish();
    }

//    //进入设置页面
//    public void onSet(View v) {
//        startActivity(new Intent(this, SetActivity.class));
//    }

    public class WrongAdapter extends ListViewAdapter{
        public WrongAdapter(Context context, List mDatas, int itemLayoutId) {
            super(context, mDatas, itemLayoutId);
        }
        @Override
        public void convert(ViewHolder helper, Object item) {
            helper.setText(R.id.tv_grade, info.getGrade());
            helper.setText(R.id.tv_unit,info.getUnit());
            helper.setText(R.id.tv_numbers,info.getNumbers());
        }
    }

}
