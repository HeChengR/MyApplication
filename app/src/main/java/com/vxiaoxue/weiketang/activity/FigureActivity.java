package com.vxiaoxue.weiketang.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v17.leanback.widget.HorizontalGridView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.vxiaoxue.weiketang.R;
import com.vxiaoxue.weiketang.adapter.RecyclerAdapter;
import com.vxiaoxue.weiketang.utils.DensityUtil;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 个人形象页面
 * Created by Administrator on 2015/11/23.
 */
public class FigureActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "FigureActivity";
    @InjectView(R.id.figure_men)
    ImageView figureMen;
    @InjectView(R.id.figure_medal)
    ImageView figureMedal;
    @InjectView(R.id.figure_title)
    ImageView figureTitle;
    @InjectView(R.id.figure_chart)
    ImageView figureChart;
    @InjectView(R.id.figure_att)
    TextView figureAtt;
    @InjectView(R.id.figure_last)
    ImageView figureLast;
    @InjectView(R.id.figure_hsv)
    HorizontalGridView figureHsv;
    @InjectView(R.id.figure_next)
    ImageView figureNext;
    @InjectView(R.id.figure_refresh)
    ImageView figureRefresh;

    private int[] mImgIds;
    private ArrayList<FigureModal> FigureList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //设置全屏显示
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_figure);
        ButterKnife.inject(this);
        initData();
        initViews();
        figureHsv.setAdapter(new FigureAdapter(this, R.layout.figure_item, FigureList));
        figureHsv.setItemMargin(DensityUtil.px2dip(this, 31));

    }
    //初始化的视图
    private void initViews() {
        figureLast.setOnClickListener(this);
        figureNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.figure_last:
                figureHsv.scrollBy(DensityUtil.px2dip(this, -430), 0);
                break;
            case R.id.figure_next:
                figureHsv.scrollBy(DensityUtil.px2dip(this, 430), 0);
                break;
        }
    }

    //初始化的数据
    public void initData() {
        FigureList = new ArrayList<>();
        mImgIds = new int[]{R.mipmap.person_g_bj_01_55, R.mipmap.person_g_bj_01_58, R.mipmap.person_g_bj_01_61,
                R.mipmap.person_g_bj_01_64, R.mipmap.person_g_bj_01_55, R.mipmap.person_g_bj_01_58, R.mipmap.person_g_bj_01_61,
                R.mipmap.person_g_bj_01_64};
        for (int index = 0; index < 8; index++) {
            FigureModal figureModal = new FigureModal();
            figureModal.setId(index);
            figureModal.setFigureImg(getResources().getDrawable(mImgIds[index]));
            FigureList.add(figureModal);
        }
    }

    //数据适配器
    class FigureAdapter extends RecyclerAdapter {
        public FigureAdapter(Context context, int ViewId, ArrayList mImgIds) {
            super(context, ViewId, mImgIds);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            FigureModal modal = FigureList.get(position);
            ViewHolder viewHolder = (ViewHolder) holder;
            ImageView imageView = (ImageView) viewHolder.itemView.findViewById(R.id.ImageView_figure_prop);
            imageView.setImageDrawable(modal.getFigureImg());
        }
    }

    //数据模型
    public class FigureModal {
        public int Id;
        public Drawable figureImg;

        public Drawable getFigureImg() {
            return figureImg;
        }

        public void setFigureImg(Drawable figureImg) {
            this.figureImg = figureImg;
        }

        public int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }
    }
}
