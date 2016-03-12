package com.woyeyo.woyeyo.view;

import com.woyeyo.woyeyo.bean.Coupon;

import java.util.List;

/**
 * Created by fam_000 on 2016/3/12.
 */
public interface ICategoryCouponView {
    void toPullFresh(List<Coupon> couponList);
    void toLoadMore(List<Coupon> list);
    void showFailedError();
}
