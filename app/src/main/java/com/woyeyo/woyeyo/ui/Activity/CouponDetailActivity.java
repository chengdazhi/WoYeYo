package com.woyeyo.woyeyo.ui.Activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.bean.Coupon;
import com.woyeyo.woyeyo.presenter.CouponDetailPresenter;
import com.woyeyo.woyeyo.utils.ToastUtil;
import com.woyeyo.woyeyo.view.IGetInfoView;



public class CouponDetailActivity extends KBaseActivity implements IGetInfoView<Coupon>{
    private Intent intent;
    private CouponDetailPresenter presenter;
    private Button buttonGet;
    private Button buttonTrade;
    private String couponJumpUrl;
    private boolean hasShow=false;
    private long couponId;
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
        buttonGet=(Button)findViewById(R.id.buttonGet);
        buttonTrade=(Button)findViewById(R.id.buttonTrade);
        buttonGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hasShow){
                    Intent jumpIntent=new Intent(Intent.ACTION_VIEW);
                    jumpIntent.setData(Uri.parse(couponJumpUrl));
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(jumpIntent);
                    } else{
                        ToastUtil.KToast(mContext,R.string.no_fit_view_activity);
                    }
                }
            }
        });
        buttonTrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpIntent=new Intent(mContext,TestTradeSquare.class);
                jumpIntent.putExtra("couponId",couponId);
                startActivity(jumpIntent);
            }
        });
    }
    @Override
    public void showInfo(Coupon coupon){
        TextView descText=(TextView)findViewById(R.id.desc);
        TextView merchantNmae=(TextView)findViewById(R.id.merchantName);
        descText.setText(coupon.getCouponDesc());
        merchantNmae.setText(coupon.getMerchantName());
        couponJumpUrl=coupon.getCouponJumpUrl();
        couponId=coupon.getCouponId();
        hasShow=true;
    }
    @Override
    public void showError(){

    }


}