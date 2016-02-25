package com.woyeyo.woyeyo.utils;

import android.app.Application;
import android.content.Context;

/**
 * Created by fam_000 on 2016/2/24.
 */
public class MyApplication extends Application {
    private static Context context;
    @Override
    public void onCreate(){
        super.onCreate();
        context=getApplicationContext();
    }
    public static Context getContext(){
        return context;
    }

}
