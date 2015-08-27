package com.vxiaoxue.weiketang.activity;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.vxiaoxue.weiketang.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2015/8/24.
 */
public class EditDataActivity extends Activity implements View.OnClickListener{
    @InjectView(R.id.edit_data_gender)
    ImageView editDataGender;
    @InjectView(R.id.ll_user_name)
    LinearLayout llUserName;
    @InjectView(R.id.edit_data_grade)
    ImageView editDataGrade;
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
        setContentView(R.layout.activity_edit_data);
        ButterKnife.inject(this);
    }

    public void onReturn(View v) {
        finish();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.edit_data_gender:
                break;
            case R.id.edit_data_grade:
                break;
        }

    }

    public void ShowPopWindow(){
        //弹出PopUpWindow
        PopupWindow mGenderPop = new PopupWindow();
        mGenderPop.setOutsideTouchable(true);
        mGenderPop.setBackgroundDrawable(new ColorDrawable(R.color.Transparent));
    }
}
