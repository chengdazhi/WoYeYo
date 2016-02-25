package com.woyeyo.woyeyo.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by fam_000 on 2016/2/24.
 */
public class BitmapResource {
    public static Bitmap  getBitmapFromResource(int resoureceid){
        Bitmap bitmap=BitmapFactory.decodeResource(
                MyApplication.getContext().getResources(), resoureceid);
        return bitmap;
    }
}
