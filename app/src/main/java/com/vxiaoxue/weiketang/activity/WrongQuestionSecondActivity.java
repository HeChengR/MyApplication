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

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2015/8/27.
 */
public class WrongQuestionSecondActivity extends Activity {
    @InjectView(R.id.wrong_listView_second)
    ListView wrongListViewSecond;

    private List  WrongSecondList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong_question_second);
        ButterKnife.inject(this);

        WrongSecondAdapter wrongSecondAdapter = new WrongSecondAdapter(this,WrongSecondList,R.layout.wrong_second_item);
        wrongListViewSecond.setAdapter(wrongSecondAdapter);
        wrongListViewSecond.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(WrongQuestionSecondActivity.this,WrongQuestionThreeActivity.class));
            }
        });
        initData();
    }
    public void initData(){

    }

    //返回
    public void onReturn(View v) {
        finish();
    }

    public class WrongSecondAdapter extends ListViewAdapter{
        public WrongSecondAdapter(Context context, List mDatas, int itemLayoutId) {
            super(context, mDatas, itemLayoutId);
        }
        @Override
        public void convert(ViewHolder helper, Object item) {

        }
    }


}
