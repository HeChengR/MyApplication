package com.vxiaoxue.weiketang.ui.polyvlist;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.easefun.polyvsdk.RestVO;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.vxiaoxue.weiketang.R;

import java.util.List;

/**
 * Created by Administrator on 2015/11/12.
 */
public class VideoAdapter extends BaseAdapter {
    private Context mContext;
    private List<RestVO> mList;
    private LayoutInflater inflater;
    DisplayImageOptions options;

    public VideoAdapter(Context context, List<RestVO> list) {
        mContext = context;
        mList = list;
        inflater = LayoutInflater.from(context);
        options = new DisplayImageOptions.Builder().showImageOnLoading(R.drawable.bg_loading).showImageForEmptyUri(R.drawable.bg_loading).showImageOnFail(R.drawable.bg_loading).bitmapConfig(Bitmap.Config.RGB_565)
                .cacheOnDisk(true).cacheInMemory(true).displayer(new FadeInBitmapDisplayer(100)).imageScaleType(ImageScaleType.IN_SAMPLE_INT).build();
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder;
        if (convertView == null) {
            mViewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.video_list, null);
            mViewHolder.mImageView = (ImageView) convertView.findViewById(R.id.mImageView);
            mViewHolder.Video_Title = (TextView) convertView.findViewById(R.id.video_title);
            mViewHolder.Video_Duration = (TextView) convertView.findViewById(R.id.video_duration);
            mViewHolder.Play_Button = (Button) convertView.findViewById(R.id.btn_play);
            mViewHolder.DownLoad_Button = (Button) convertView.findViewById(R.id.btn_download);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        RestVO list = mList.get(position);
        mViewHolder.Video_Title.setText(list.getTitle());
        mViewHolder.Video_Duration.setText(list.getDuration());
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(list.getFirstImage(), mViewHolder.mImageView, options,new MyImageLoadingListener());
        return convertView;
    }

    class ViewHolder {
        public ImageView mImageView;
        public TextView Video_Title;
        public TextView Video_Duration;
        public Button Play_Button;
        public Button DownLoad_Button;
    }
}
