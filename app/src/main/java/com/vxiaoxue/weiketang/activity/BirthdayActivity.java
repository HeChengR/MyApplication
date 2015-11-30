package com.vxiaoxue.weiketang.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.ImageButton;

import com.vxiaoxue.weiketang.R;

import java.util.Calendar;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2015/9/23.
 */
public class BirthdayActivity extends Activity {
    @InjectView(R.id.birthday_dataPicker)
    DatePicker birthdayDataPicker;
    @InjectView(R.id.mImageButton_dataPicker)
    ImageButton mImageButtonDataPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置全屏显示
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.birthday_selecter);
        ButterKnife.inject(this);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int monthOfYear = calendar.get(Calendar.MONTH);
        final int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        mImageButtonDataPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(BirthdayActivity.this, EditDataActivity.class);
                intent.putExtra("year", year);
                intent.putExtra("monthOfYear", monthOfYear);
                intent.putExtra("dayOfMonth", dayOfMonth);
                setResult(2000, intent);
                finish();
            }
        });
        birthdayDataPicker.init(year, monthOfYear, dayOfMonth, new DatePicker.OnDateChangedListener() {
            //数据改变的时候去调用
            public void onDateChanged(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
//                Toast.makeText(BirthdayActivity.this, "您选择的日期是：" + year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日。", Toast.LENGTH_SHORT).show();
            }

        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.finish();
        return true;
    }
}
