package com.woyeyo.woyeyo.model;

import android.test.AndroidTestCase;
import android.util.Log;

import com.woyeyo.woyeyo.bean.Coupon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengdazhi on 4/9/16.
 */
public class CouponDbHelperTest extends AndroidTestCase {

    public void testCache(){
        List<Coupon> list = new ArrayList<Coupon>();
        Coupon coupon1 = new Coupon();
        coupon1.setCouponId(1l);
        coupon1.setCouponImageUrl("http://7xpg2f.com1.z0.glb.clouddn.com/bg_tab_s_2.jpg");
        coupon1.setCouponDesc("big face photo");

        Coupon coupon2 = new Coupon();
        coupon2.setCouponId(2l);
        coupon2.setCouponImageUrl("http://7xpg2f.com1.z0.glb.clouddn.com/bg_tab_3.jpg");
        coupon2.setCouponDesc("big face photo 2");

        list.add(coupon1);
        list.add(coupon2);

        boolean flag = new CouponListCacheDbHelperImpl(getContext(), "Coupon", null, 1).cacheCouponList(list);
        assertEquals(flag, true);
    }

    public void testGet(){
        List<Coupon> list = new CouponListCacheDbHelperImpl(getContext(), "Coupon", null, 1).getCouponList();
        for(Coupon coupon : list) {
            Log.d("DbHelper", coupon.getCouponId() + "|" + coupon.getCouponImageAbsolutePath() + "|" + coupon.getCouponDesc());
        }

    }
}
