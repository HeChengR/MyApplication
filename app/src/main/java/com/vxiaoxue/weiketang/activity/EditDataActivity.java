package com.vxiaoxue.weiketang.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vxiaoxue.weiketang.R;
import com.vxiaoxue.weiketang.ui.MyPopUpWindow;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 个人资料编辑页面
 * 注：个人资料选择完成后点击保存退出页面并且显示在个人资料显示页面。
 * Created by Administrator on 2015/8/24.
 */
public class EditDataActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "EditDataActivity";

    @InjectView(R.id.mEditView_UserName)
    EditText mEditViewUserName;//用户名
    @InjectView(R.id.mTextView_gender)
    TextView mTextViewGender;
    @InjectView(R.id.mImageButton_edit_gender)
    ImageButton mImageButtonEditGender;
    @InjectView(R.id.RL_gender)
    RelativeLayout RLGender;
    @InjectView(R.id.mEditView_tel)
    EditText mEditViewTel;
    @InjectView(R.id.mEditView_mail)
    EditText mEditViewMail;
    @InjectView(R.id.mTextView_birthday)
    EditText mTextViewBirthday;
    @InjectView(R.id.mTextView_DistrictName)
    TextView mTextViewDistrictName;
    @InjectView(R.id.mTextView_grade)
    TextView mTextViewGrade;
    @InjectView(R.id.mImageButton_edit_grade)
    ImageButton mImageButtonEditGrade;
    @InjectView(R.id.RL_grade)
    RelativeLayout RLGrade;
    @InjectView(R.id.mEditView_school)
    EditText mEditViewSchool;
    @InjectView(R.id.mEditView_parent)
    EditText mEditViewParent;
    @InjectView(R.id.mEditView_ParentTel)
    EditText mEditViewParentTel;
    @InjectView(R.id.Reward_data)
    TextView RewardData;
    @InjectView(R.id.Edit_data)
    ImageButton EditData;
    @InjectView(R.id.Save_data)
    ImageButton SaveData;

    private Boolean isemail;

    private String mDistrict;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置全屏显示
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_edit_data);
        ButterKnife.inject(this);
        initView();
    }

    //初始化视图
    private void initView() {
        mImageButtonEditGender.setOnClickListener(this);//性别
        mImageButtonEditGrade.setOnClickListener(this);//年级
        RLGender.setOnClickListener(this);//性别
        RLGrade.setOnClickListener(this);//年级
        mTextViewBirthday.setOnClickListener(this);//生日
        mTextViewDistrictName.setOnClickListener(this);//地区选择器
        EditData.setOnClickListener(this);//编辑
        SaveData.setOnClickListener(this);//保存
    }

    @Override
    public void onClick(View v) {
        //性别选择，弹出一个PopUpWindow  后期用点9图改善背景图片，需要准确的确定PopUpWindow的位置
        if (v.getId() == R.id.RL_gender || v.getId() == R.id.mImageButton_edit_gender) {
            //点击选择性别，弹出一个Pop
            final MyPopUpWindow PopUpWindow = new MyPopUpWindow(this);
            PopUpWindow.setLayoutParams(R.layout.gender_dialog);
            PopUpWindow.setAnimationStyle(R.anim.fade);
            PopShowLocation(PopUpWindow,RLGender);
            View mMenuView = PopUpWindow.getmMenuView();
            final TextView mTextViewMen = (TextView) mMenuView.findViewById(R.id.tv_men);
            final TextView mTextViewWoMen = (TextView) mMenuView.findViewById(R.id.tv_women);
            final ImageButton mImageButtonGender = (ImageButton) mMenuView.findViewById(R.id.mImageButton_gender);
            mTextViewMen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Toast.makeText(EditDataActivity.this, mTextViewMen.getText().toString(), Toast.LENGTH_SHORT).show();
                    mTextViewGender.setText(mTextViewMen.getText().toString());
                    PopUpWindow.dismiss();
                }
            });
            mTextViewWoMen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Toast.makeText(EditDataActivity.this, mTextViewWoMen.getText().toString(), Toast.LENGTH_SHORT).show();
                    mTextViewGender.setText(mTextViewWoMen.getText().toString());
                    PopUpWindow.dismiss();
                }
            });

            mImageButtonGender.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopUpWindow.dismiss();
                }
            });
            //年级选择器，布局外层可滑动的ScrollView显示查看当前的所有年级。
        } else if (v.getId() == R.id.RL_grade || v.getId() == R.id.mImageButton_edit_grade) {
            final MyPopUpWindow PopUpWindow = new MyPopUpWindow(this);
            PopUpWindow.setLayoutParams(R.layout.grade_dialog);
            PopUpWindow.setAnimationStyle(R.anim.fade);
            PopShowLocation(PopUpWindow,RLGrade);
            View mMenuView = PopUpWindow.getmMenuView();
            final TextView mTextViewGrade_01 = (TextView) mMenuView.findViewById(R.id.grade_01);
            final TextView mTextViewGrade_02 = (TextView) mMenuView.findViewById(R.id.grade_02);
            final TextView mTextViewGrade_03 = (TextView) mMenuView.findViewById(R.id.grade_03);
            final TextView mTextViewGrade_04 = (TextView) mMenuView.findViewById(R.id.grade_04);
            final TextView mTextViewGrade_05 = (TextView) mMenuView.findViewById(R.id.grade_05);
            final TextView mTextViewGrade_06 = (TextView) mMenuView.findViewById(R.id.grade_06);
            final ImageButton mImageButtonGrade = (ImageButton) mMenuView.findViewById(R.id.mImageButton_grade);
            mTextViewGrade_01.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mTextViewGrade.setText(mTextViewGrade_01.getText().toString());
                    PopUpWindow.dismiss();
                }
            });
            mTextViewGrade_02.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mTextViewGrade.setText(mTextViewGrade_02.getText().toString());
                    PopUpWindow.dismiss();
                }
            });
            mTextViewGrade_03.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mTextViewGrade.setText(mTextViewGrade_03.getText().toString());
                    PopUpWindow.dismiss();
                }
            });
            mTextViewGrade_04.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mTextViewGrade.setText(mTextViewGrade_04.getText().toString());
                    PopUpWindow.dismiss();
                }
            });
            mTextViewGrade_05.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mTextViewGrade.setText(mTextViewGrade_05.getText().toString());
                    PopUpWindow.dismiss();
                }
            });
            mTextViewGrade_06.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mTextViewGrade.setText(mTextViewGrade_06.getText().toString());
                    PopUpWindow.dismiss();
                }
            });
            mImageButtonGrade.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopUpWindow.dismiss();
                }
            });
        }
        switch (v.getId()) {
            case R.id.mTextView_birthday://自定义的生日选择器
                startActivityForResult(new Intent(this, BirthdayActivity.class), 2000);
                break;
            case R.id.mTextView_DistrictName://自定义的地区选择器，开启一个新的页面，每次选择完毕再次选择的时候要将之前的页面finish掉，要不然会出现很多页面重叠的现象。
                startActivityForResult(new Intent(this, PlaceActivity.class), 1000);
                break;
            case R.id.mEditView_school://选择学校
                break;
            case R.id.Save_data://保存到本地一份，上传到服务器一份。本地用于显示资料
                String UserName = mEditViewUserName.getText().toString().trim();
                String Gender = mTextViewGender.getText().toString().trim();
                String Tel = mEditViewTel.getText().toString().trim();
                String Mail = mEditViewMail.getText().toString().trim();
                String Birthday = mTextViewBirthday.getText().toString().trim();
                String DistrictName = mTextViewDistrictName.getText().toString().trim();
                String Grade = mTextViewGrade.getText().toString().trim();
                String School = mEditViewSchool.getText().toString().trim();
                String Parent = mEditViewParent.getText().toString().trim();
                String ParentTel = mEditViewParentTel.getText().toString().trim();
                Intent intent = new Intent();
                intent.setClass(EditDataActivity.this, SetDataActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("username", UserName);
                bundle.putString("Gender", Gender);
                bundle.putString("Tel", Tel);
                bundle.putString("Mail", Mail);
                bundle.putString("Birthday", Birthday);
                bundle.putString("DistrictName", DistrictName);
                bundle.putString("Grade", Grade);
                bundle.putString("School", School);
                bundle.putString("Parent", Parent);
                bundle.putString("ParentTel", ParentTel);
                intent.putExtra("bundle", bundle);
                setResult(1000, intent);
                finish();
                break;
        }
    }

    /**
     * 验证手机格式
     */
    public static boolean isMobileNO(String mobiles) {
    /*
    移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
    联通：130、131、132、152、155、156、185、186
    电信：133、153、180、189、（1349卫通）
    总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
    */
        String telRegex = "[1][358]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles)) return false;
        else return mobiles.matches(telRegex);
    }

    /**
     * 判断email格式是否正确
     *
     * @param email
     * @return
     */
    public boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * 判断是否全是数字
     *
     * @param str
     * @return
     */
    public boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            if (requestCode == 1000) {
                mDistrict = data.getStringExtra("com.vxiaoxue.weiketang.district");
                mTextViewDistrictName.setText(mDistrict);
                mTextViewDistrictName.setTextColor(getResources().getColor(R.color.appBlack));
                Log.e(TAG, mDistrict);
            } else if (requestCode == 2000) {
                int year = data.getIntExtra("year", 0);
                int monthOfYear = data.getIntExtra("monthOfYear", 1);
                int dayOfMonth = data.getIntExtra("dayOfMonth", 2);
                mTextViewBirthday.setText(year + "-" + monthOfYear + "-" + dayOfMonth);
                mTextViewDistrictName.setTextColor(getResources().getColor(R.color.appBlack));
            }
        }
    }

    /**
     * POP的位置
     * @param Pop
     * @param ParentView
     */
    public void PopShowLocation(PopupWindow Pop,View ParentView){
        int[] location = new int[2];
        ParentView.getLocationOnScreen(location);
        Pop.showAtLocation(ParentView, Gravity.NO_GRAVITY, location[0], location[1] - Pop.getHeight() - 2);
    }
}
