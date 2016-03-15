package com.woyeyo.woyeyo.presenter;

import android.os.Handler;

import com.woyeyo.woyeyo.model.GetCoupon;
import com.woyeyo.woyeyo.model.IGetCoupon;
import com.woyeyo.woyeyo.view.ICategoryCouponView;
import com.woyeyo.woyeyo.view.ICouponListView;

import java.util.List;

/**
 * Created by fam_000 on 2016/3/12.
 */
public class CategoryCouponPresenter {
    private ICategoryCouponView iCategoryCouponView;
    private IGetCoupon iGetCoupon;
    private Handler mHandler=new Handler();
    public CategoryCouponPresenter(ICategoryCouponView iCategoryCouponView){
        this.iCategoryCouponView=iCategoryCouponView;
        this.iGetCoupon=new GetCoupon();
    }
    public void getInfoIntoView(final long topId,final String category,
                                final int itemCount){
        iGetCoupon.getCategoryCoupon(topId , category,itemCount, new OnCategoryCouponListener() {
            @Override
            public void getInfoSuccess(final List list) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (itemCount == 0) {
                            iCategoryCouponView.toPullFresh(list);
                        } else {
                            iCategoryCouponView.toLoadMore(list);
                        }
                    }
                });
            }

            @Override
            public void getInfoFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iCategoryCouponView.showFailedError();
                    }
                });
            }
        });

    }
}
