package com.vxiaoxue.weiketang.ui.polyvlist;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.easefun.polyvsdk.PolyvSDKClient;
import com.easefun.polyvsdk.RestVO;
import com.vxiaoxue.weiketang.R;

import org.json.JSONException;

import java.util.List;

/**
 * Created by Administrator on 2015/11/12.
 */
public class VideoListActivity extends Activity {
    private static final String TAG = "VideoListActivity";
    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        list = (ListView)findViewById(R.id.Video_ListView);
        Log.e(TAG, "我一直都在呀");

        new LoadVideoList().execute();
    }
    class LoadVideoList extends AsyncTask<String, String, List<RestVO>> {

        @Override
        protected List<RestVO> doInBackground(String... arg0) {
            try {
                return PolyvSDKClient.getInstance().getVideoList(1, 10);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<RestVO> result) {
            super.onPostExecute(result);
            VideoAdapter adapter = new VideoAdapter(VideoListActivity.this, result);
            list.setAdapter(adapter);
            String a = result.toString();
            System.out.print(a);
            Log.e(TAG, a);
        }
    }
}
