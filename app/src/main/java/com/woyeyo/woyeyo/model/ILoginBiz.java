package com.woyeyo.woyeyo.model;

import com.woyeyo.woyeyo.presenter.OnLoginListener;

/**
 * Created by chengdazhi on 4/6/16.
 */
public interface ILoginBiz {

    public void login(String userId, String password, OnLoginListener listener);
}
