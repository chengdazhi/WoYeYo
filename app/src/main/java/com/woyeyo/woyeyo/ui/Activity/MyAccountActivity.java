package com.woyeyo.woyeyo.ui.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.ui.CustomUi.CustomCircle;
import com.woyeyo.woyeyo.utils.Clog;
import com.woyeyo.woyeyo.utils.ToastUtil;

/**
 * Created by DongBaishun on 2016/4/3.
 */
public class MyAccountActivity extends KBaseActivity{
    private CustomCircle customCircle;
    private LinearLayout getMoney;
    private LinearLayout tradeHistory;
    private LinearLayout adressMana;
    private TextView nowMoneyText;
    private TextView futureMoneyText;
    public void setResId() {
        mainResId = R.layout.activity_my_account;
    }

    public void setToolBarTitle() {
        title = R.string.account_title;
    }

   public void initSpecialView(){
       float now=200.5f;
       float future=50.5f;

       customCircle = (CustomCircle) findViewById(R.id.customCircle);
       getMoney=(LinearLayout)findViewById(R.id.get_money_ll);
       tradeHistory=(LinearLayout)findViewById(R.id.trade_history_ll);
       adressMana=(LinearLayout)findViewById(R.id.address_manage_ll);
       nowMoneyText=(TextView)findViewById(R.id.now_money_num);
       futureMoneyText=(TextView)findViewById(R.id.future_money_num);
       nowMoneyText.setText(String.valueOf(now));
       futureMoneyText.setText(String.valueOf(future));

       customCircle.setMoney(now, future);
       getMoney.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ToastUtil.KToast(mContext, R.string.not_ready);
           }
       });
       tradeHistory.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(mContext,TradeHistoryActivity.class);
               startActivity(intent);
           }
       });
       adressMana.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //TODO:here should be manageAdressActivity.class
               Intent intent=new Intent(mContext,ChooseAddressActivity.class);
               startActivity(intent);
           }
       });

    }

}
