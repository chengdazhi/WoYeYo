package com.woyeyo.woyeyo.model;

import android.content.Context;

import com.woyeyo.woyeyo.bean.Coupon;

import java.util.List;

/**
 * Created by chengdazhi on 4/7/16.
 */
public class CouponListCacheImpl implements CouponListCache{

    @Override
    public boolean cacheCouponListToDb(List<Coupon> couponList, Context context) {
        boolean flag = new CouponListCacheDbHelperImpl(context, "Coupon", null, 1)
                .cacheCouponList(couponList);
        return flag;
    }

    @Override
    public List<Coupon> getCouponListCache(Context context) {
        return new CouponListCacheDbHelperImpl(context, "Coupon", null, 1).getCouponList();
    }
}
