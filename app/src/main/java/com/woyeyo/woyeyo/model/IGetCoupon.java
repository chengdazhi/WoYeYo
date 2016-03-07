package com.woyeyo.woyeyo.model;

import com.woyeyo.woyeyo.presenter.OnCouponInfoListener;

/**
 * Created by fam_000 on 2016/3/6.
 */
public interface IGetCoupon {
    void getTopCoupon();
    void getAllCoupon(final long couponTopId,long scrollImgTopId,
                      final int itemCount,OnCouponInfoListener listener);
    void getCouponDetail(final long couponId);
}
