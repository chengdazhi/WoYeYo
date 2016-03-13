package com.woyeyo.woyeyo.utils;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

/**
 * Created by fam_000 on 2016/2/24.
 */
public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate(){
        super.onCreate();
        context=getApplicationContext();
        initImageLoader(getApplicationContext());
    }
    public static void initImageLoader(Context context){
        ImageLoaderConfiguration config = ImageLoaderConfiguration.createDefault(context);
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config);
    }
    public static Context getContext(){
        return context;
    }

}
