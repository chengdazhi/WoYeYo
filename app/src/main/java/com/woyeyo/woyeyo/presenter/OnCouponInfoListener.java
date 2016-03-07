package com.woyeyo.woyeyo.presenter;

import java.util.List;

/**
 * Created by fam_000 on 2016/3/7.
 */
public interface OnCouponInfoListener  {
    void getInfoSuccess(final List list,final String slogan,List<String> scrollImgUrl);
    void getInfoFailed();

}
