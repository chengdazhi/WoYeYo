package com.woyeyo.woyeyo.presenter;

import com.woyeyo.woyeyo.bean.TradeInfo;

import java.util.List;

/**
 * Created by fam_000 on 2016/2/24.
 */
public interface OnInfoListener {
    void getInfoSuccess(List list);
    void getInfoFailed();
}
