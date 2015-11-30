package com.vxiaoxue.weiketang.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.vxiaoxue.weiketang.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 个人资料显示页面
 * Created by Administrator on 2015/8/22.
 */
public class SetDataActivity extends BaseActivity implements View.OnClickListener {
    @InjectView(R.id.User_name)
    TextView UserName;
    @InjectView(R.id.Gender_data)
    TextView GenderData;
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_data);
        ButterKnife.inject(this);
        EditData.setOnClickListener(this);
        SaveData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.Edit_data:
                startActivityForResult(new Intent(this, EditDataActivity.class), 1000);
                break;
            case R.id.Gender_data:
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data!=null){
            if (requestCode == 1000) {
                Bundle bundle = data.getBundleExtra("bundle");
                String username = bundle.getString("username");
                String Gender = bundle.getString("Gender");
                String Tel = bundle.getString("Tel");
                String Mail = bundle.getString("Mail");
                String Birthday = bundle.getString("Birthday");
                String DistrictName = bundle.getString("DistrictName");
                String Grade = bundle.getString("Grade");
                String School = bundle.getString("School");
                String Parent = bundle.getString("Parent");
                String ParentTel = bundle.getString("ParentTel");
                UserName.setText(username);
                GenderData.setText(Gender);
                TelData.setText(Tel);
                mailData.setText(Mail);
                BirthdayData.setText(Birthday);
                AreaData.setText(DistrictName);
                GradeData.setText(Grade);
                SchoolData.setText(School);
                ParentNameData.setText(Parent);
                ParentTelData.setText(ParentTel);
            }
        }
    }
}
