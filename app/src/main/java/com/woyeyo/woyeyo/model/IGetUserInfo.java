package com.woyeyo.woyeyo.model;

import com.woyeyo.woyeyo.presenter.OnGetUserInfoListener;
import com.woyeyo.woyeyo.presenter.OnInfoListener;

/**
 * Created by fam_000 on 2016/3/15.
 */
public interface IGetUserInfo {
    void getUserInfo(String token,OnGetUserInfoListener listener);
    void getSellerInfo(String token,OnGetUserInfoListener listener);
}
