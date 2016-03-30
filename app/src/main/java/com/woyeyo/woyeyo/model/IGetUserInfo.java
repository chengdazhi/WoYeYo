package com.woyeyo.woyeyo.model;

import android.graphics.Bitmap;

import com.woyeyo.woyeyo.presenter.OnGetUserInfoListener;
import com.woyeyo.woyeyo.presenter.OnInfoListener;
import com.woyeyo.woyeyo.presenter.OnSendInfoListener;

/**
 * Created by fam_000 on 2016/3/15.
 */
public interface IGetUserInfo {
    void getUserInfo(String token,OnGetUserInfoListener listener);
    void getSellerInfo(String token,OnGetUserInfoListener listener);
    void changeUserSex(boolean isMan,OnSendInfoListener listener);
    void changeUserPhoto(Bitmap bitmap,OnSendInfoListener listener);
}
