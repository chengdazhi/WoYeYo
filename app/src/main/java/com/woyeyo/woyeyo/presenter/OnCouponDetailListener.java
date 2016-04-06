package com.woyeyo.woyeyo.presenter;

import com.woyeyo.woyeyo.bean.Coupon;

import java.util.List;

/**
 * Created by fam_000 on 2016/3/20.
 */
public interface OnCouponDetailListener {
    void getInfoSuccess(Coupon coupon);
    void getInfoFailed();
}
