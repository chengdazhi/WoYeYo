package com.woyeyo.woyeyo.utils;

import android.content.Context;
import android.widget.Toast;

import com.woyeyo.woyeyo.R;

/**
 * Created by fam_000 on 2016/3/22.
 */
public class ToastUtil {
    public static void KToast(Context context,String content){
        Toast.makeText(context,content,Toast.LENGTH_SHORT).show();
    }
    public static void KToast(Context context,int resourceId){
        Toast.makeText(context,resourceId,Toast.LENGTH_SHORT).show();
    }
}
