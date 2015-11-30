package com.vxiaoxue.weiketang.activity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.vxiaoxue.weiketang.R;
import com.vxiaoxue.weiketang.utils.ToastUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 意见建议页面
 * Created by Administrator on 2015/8/24.
 */
public class OpinionActivity extends BaseActivity {
    @InjectView(R.id.et_opinion)
    EditText etOpinion;
    @InjectView(R.id.opinion_submit)
    ImageButton opinionSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opinion);
        ButterKnife.inject(this);
        etOpinion.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);//设置文字多行显示
        etOpinion.setSingleLine(false);//禁止单行显示
        etOpinion.setHorizontallyScrolling(false);//禁止横向滚动
        //点击提交到服务器
        opinionSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Opinion = etOpinion.getText().toString().trim();
                ToastUtils.showShort(OpinionActivity.this, Opinion);
            }
        });
    }
}
