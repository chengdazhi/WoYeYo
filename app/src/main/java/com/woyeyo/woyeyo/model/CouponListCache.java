package com.woyeyo.woyeyo.model;

import android.content.Context;

import com.woyeyo.woyeyo.bean.Coupon;

import java.util.List;

/**
 * Created by chengdazhi on 4/7/16.
 */
public interface CouponListCache {

    public boolean cacheCouponListToDb(List<Coupon> couponList, Context context);

    public List<Coupon> getCouponListCache(Context context);

}
