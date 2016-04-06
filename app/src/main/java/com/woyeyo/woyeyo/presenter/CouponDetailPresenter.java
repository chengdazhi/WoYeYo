package com.woyeyo.woyeyo.presenter;

import android.os.Handler;

import com.woyeyo.woyeyo.bean.Coupon;
import com.woyeyo.woyeyo.model.GetCoupon;
import com.woyeyo.woyeyo.model.IGetCoupon;
import com.woyeyo.woyeyo.view.IGetInfoView;

/**
 * Created by fam_000 on 2016/3/20.
 */
public class CouponDetailPresenter {
    private IGetInfoView<Coupon> iGetInfoView;
    private IGetCoupon iGetCoupon;
    private Handler mHandler=new Handler();
    public CouponDetailPresenter(IGetInfoView<Coupon> iGetInfoView){
        this.iGetInfoView=iGetInfoView;
        this.iGetCoupon=new GetCoupon();
    }
    public void getCouponDetail(final long id){
        iGetCoupon.getCouponDetail(id, new OnCouponDetailListener() {
            @Override
            public void getInfoSuccess(final Coupon coupon) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iGetInfoView.showInfo(coupon);
                    }
                });
            }

            @Override
            public void getInfoFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iGetInfoView.showError();
                    }
                });
            }
        });

    }
}
