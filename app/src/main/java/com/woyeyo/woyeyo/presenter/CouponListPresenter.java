package com.woyeyo.woyeyo.presenter;

import android.os.Handler;

import com.woyeyo.woyeyo.model.GetCoupon;
import com.woyeyo.woyeyo.model.IGetCoupon;
import com.woyeyo.woyeyo.view.ICouponListView;

import java.util.List;

/**
 * Created by fam_000 on 2016/3/6.
 */
public class CouponListPresenter{
    private ICouponListView iCouponListView;
    private IGetCoupon iGetCoupon;
    private Handler mHandler=new Handler();
    public CouponListPresenter(ICouponListView iCouponListView){
        this.iCouponListView=iCouponListView;
        this.iGetCoupon=new GetCoupon();
    }
    public void getInfoIntoView(final long topId,final long scrollImgId,
                                final int itemCount){
        iGetCoupon.getAllCoupon(topId,scrollImgId,itemCount, new OnCouponInfoListener(){
            @Override
            public void getInfoSuccess(final List list, final String slogan,
                                       final List<String> scrollImgUrl) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(itemCount==0){
                            iCouponListView.toPullFresh(list,slogan,scrollImgUrl);
                        }
                        else{
                            iCouponListView.toLoadMore(list);
                        }
                    }
                });
            }

            @Override
            public void getInfoFailed() {
                iCouponListView.showFailedError();

            }
        });

    }
}
