package com.woyeyo.woyeyo.view;

import com.woyeyo.woyeyo.bean.Coupon;

import java.util.List;

/**
 * Created by fam_000 on 2016/3/6.
 */
public interface ICouponListView{
    void toPullFresh(List<Coupon> couponList,String slogan,List<String> scrollImgList);
    void toLoadMore(List<Coupon> list);
    void showFailedError();
}
