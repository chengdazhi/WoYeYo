package com.woyeyo.woyeyo.ui.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.presenter.OnCategoryCouponListener;

public class CategoryCouponActivity extends KBaseActivity {
   public void setResId(){
       mainResId=R.layout.activity_category_coupon;
       toolbarResId=R.id.category_coupon_toolbar;
   }
   public void setToolBarTitle(){
       String flag=getIntent().getStringExtra("category");
       switch (flag){
           case "mov":title=R.string.mov_category;
               break;
           case "buy":title=R.string.buy_category;
               break;
           default:break;
       }
   }



}
