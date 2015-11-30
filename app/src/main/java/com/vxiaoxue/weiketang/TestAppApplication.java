package com.vxiaoxue.weiketang;

import android.app.Application;
import android.os.Environment;

import com.easefun.polyvsdk.PolyvSDKClient;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;
import com.vxiaoxue.weiketang.ui.font.MagicView;
import com.vxiaoxue.weiketang.ui.polyvlist.PolyvService;

import java.io.File;

/**
 * Created by Administrator on 2015/10/8.
 */
public class TestAppApplication extends Application {
    private File file;
    @Override
    public void onCreate() {
        super.onCreate();
        MagicView.setFontsPath(this,"font");

        File CacheFile = StorageUtils.getOwnCacheDirectory(getApplicationContext(), "/PloyvLoading/cache");
        ImageLoaderConfiguration config = new ImageLoaderConfiguration
                .Builder(getApplicationContext())
                .memoryCacheExtraOptions(480, 800) // max width, max height，即保存的每个缓存文件的最大长宽
                .threadPoolSize(3)//线程池内加载的数量
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024)) // You can pass your own memory cache implementation/你可以通过自己的内存缓存实现
                .memoryCacheSize(2 * 1024 * 1024)
                .discCacheSize(50 * 1024 * 1024)
                .discCacheFileNameGenerator(new Md5FileNameGenerator())//将保存的时候的URI名称用MD5 加密
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .discCacheFileCount(100) //缓存的文件数量
                .discCache(new UnlimitedDiscCache(CacheFile))//自定义缓存路径
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple())
                .imageDownloader(new BaseImageDownloader(getApplicationContext(), 5 * 1000, 30 * 1000)) // connectTimeout (5 s), readTimeout (30 s)超时时间
                .writeDebugLogs() // Remove for release app
                .build();//开始构建
        ImageLoader.getInstance().init(config);
        initPolyvSDK();
    }
    public void initPolyvSDK() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {//存储媒体已经挂载,并且挂载点可读可写.
            file = new File(Environment.getExternalStorageDirectory().getPath() + "/DownLoadPoly");
            if (!file.exists()) {
                file.mkdir();
            }
        }
        PolyvSDKClient Client = PolyvSDKClient.getInstance();
        Client.setPrivatekey("lr3cJox9Ta");
        Client.setWritetoken("E1FLnPnSIPY3IyE-UDQHOGWBXH0SKUJ9");
        Client.setReadtoken("izS8RjsdBv-GxHfy3mgJ7-ALrON4zRYn");
        Client.setUserId("5fd714ac32");
        Client.startService(this, PolyvService.class);
    }
}
