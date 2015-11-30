package com.vxiaoxue.weiketang.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.vxiaoxue.weiketang.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2015/9/16.
 */
public class NavigationEventContentActivity extends BaseActivity {
    @InjectView(R.id.event_content_text)
    TextView eventContentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_event_content);
        ButterKnife.inject(this);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        eventContentText.setText(title);
    }
}
