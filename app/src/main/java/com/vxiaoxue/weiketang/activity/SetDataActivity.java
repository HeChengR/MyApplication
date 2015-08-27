package com.vxiaoxue.weiketang.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vxiaoxue.weiketang.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2015/8/22.
 */
public class SetDataActivity extends Activity implements View.OnClickListener {

    @InjectView(R.id.User_name)
    TextView UserName;
    @InjectView(R.id.Gender_data)
    TextView GenderData;
    @InjectView(R.id.ll_user_name)
    LinearLayout llUserName;
    @InjectView(R.id.Tel_data)
    TextView TelData;
    @InjectView(R.id.mail_data)
    TextView mailData;
    @InjectView(R.id.Birthday_data)
    TextView BirthdayData;
    @InjectView(R.id.Area_data)
    TextView AreaData;
    @InjectView(R.id.Grade_data)
    TextView GradeData;
    @InjectView(R.id.School_data)
    TextView SchoolData;
    @InjectView(R.id.ParentName_data)
    TextView ParentNameData;
    @InjectView(R.id.ParentTel_data)
    TextView ParentTelData;
    @InjectView(R.id.Reward_data)
    TextView RewardData;
    @InjectView(R.id.Edit_data)
    ImageButton EditData;
    @InjectView(R.id.Save_data)
    ImageButton SaveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_data);
        ButterKnife.inject(this);

        EditData.setOnClickListener(this);
        SaveData.setOnClickListener(this);
    }

    public void onReturn(View v) {
        finish();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.Edit_data) {
            startActivity(new Intent(this, EditDataActivity.class));
        } else if (v.getId() == R.id.Save_data) {

        }
    }
}
