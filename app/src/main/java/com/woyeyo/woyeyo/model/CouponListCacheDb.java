package com.woyeyo.woyeyo.model;

import com.woyeyo.woyeyo.bean.Coupon;

import java.util.List;

/**
 * Created by chengdazhi on 4/7/16.
 */
public interface CouponListCacheDb {

    public boolean cacheCouponList(List<Coupon> couponList);

    public List<Coupon> getCouponList();

}
