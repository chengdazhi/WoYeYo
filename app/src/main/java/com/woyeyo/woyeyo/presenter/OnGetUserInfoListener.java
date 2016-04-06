package com.woyeyo.woyeyo.presenter;

import com.woyeyo.woyeyo.bean.User;

/**
 * Created by fam_000 on 2016/3/15.
 */
public interface OnGetUserInfoListener {
    void getInfoSuccess(User user);
    void getInfoFailed();

}
