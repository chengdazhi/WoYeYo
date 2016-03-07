package com.woyeyo.woyeyo.model;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.bean.Coupon;
import com.woyeyo.woyeyo.bean.TradeInfo;
import com.woyeyo.woyeyo.presenter.OnCouponInfoListener;
import com.woyeyo.woyeyo.presenter.OnInfoListener;
import com.woyeyo.woyeyo.utils.BitmapResource;
import com.woyeyo.woyeyo.utils.Clog;
import com.woyeyo.woyeyo.utils.UrlConstants;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by fam_000 on 2016/3/6.
 */
public class GetCoupon implements IGetCoupon {
    private final int showNum=5;
    private final int scrollShowNum=3;
    public void getAllCoupon(final long topId,final long scrollImgTopId,
                             final int itemCount,final OnCouponInfoListener listener){
        new Thread(){
            @Override
            public void run(){
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if(true){
                    //TODO judge if get proper info
                    List<Coupon> list=new ArrayList<Coupon>();
                    String[] imgUrl=UrlConstants.imgs;
                    for(int i=0;i<showNum;i++){
                        Coupon coupon=new Coupon();
                        if(i+itemCount<imgUrl.length){
                            coupon.setCouponImageUrl(imgUrl[i+itemCount]);
                            Clog.d("f",""+ i + itemCount);
                        }
                        else{
                            coupon.setCouponImageUrl(UrlConstants.noMoreResult);
                        }
                        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss ");
                        Date curDate=new Date(System.currentTimeMillis()+itemCount*1000);
                        coupon.setCouponDesc("good!" +formatter.format(curDate) );
                        list.add(coupon);
                    }

                    String slogan;
                    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss ");
                    Date curDate=new Date(System.currentTimeMillis());
                    slogan="hello~" +formatter.format(curDate);

                    String[] wholeScrollImgUrl=UrlConstants.ScrollImage;
                    List<String> scrollImgsUrl=new ArrayList<String>();
                    for(int i=0;i<scrollShowNum;i++){
                        if(i+scrollImgTopId<wholeScrollImgUrl.length){
                            scrollImgsUrl.add(wholeScrollImgUrl[i]);
                        }
                        else{
                            scrollImgsUrl.add(UrlConstants.noMoreResult);
                        }
                    }

                    listener.getInfoSuccess(list,slogan,scrollImgsUrl);
                }
                else {
                    listener.getInfoFailed();
                }
            }
        }.start();
    }
    public void getCouponDetail(final long couponId){

    }
    public void getTopCoupon(){

    }
}
