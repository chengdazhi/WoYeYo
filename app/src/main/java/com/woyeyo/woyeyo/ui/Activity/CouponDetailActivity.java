package com.woyeyo.woyeyo.ui.Activity;

import android.content.Intent;
import android.widget.TextView;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.bean.Coupon;
import com.woyeyo.woyeyo.presenter.CouponDetailPresenter;
import com.woyeyo.woyeyo.view.IGetInfoView;



public class CouponDetailActivity extends KBaseActivity implements IGetInfoView<Coupon>{
    private Intent intent;
    private CouponDetailPresenter presenter;
    public void setResId(){
        mainResId= R.layout.activity_coupon_detail;
        toolbarResId=R.id.test_main_page_toolbar;
    }
    public void setToolBarTitle(){
        title=R.string.coupon_detail_title;
    }
    @Override
    public void initSpecialView(){
        intent=getIntent();
        long id=intent.getLongExtra("couponId",0);
        presenter=new CouponDetailPresenter(CouponDetailActivity.this);
        presenter.getCouponDetail(id);
    }
    @Override
    public void showInfo(Coupon coupon){
        TextView descText=(TextView)findViewById(R.id.desc);
        TextView merchantNmae=(TextView)findViewById(R.id.merchantName);
        descText.setText(coupon.getCouponDesc());
        merchantNmae.setText(coupon.getMerchantName());
    }
    @Override
    public void showError(){

    }


}