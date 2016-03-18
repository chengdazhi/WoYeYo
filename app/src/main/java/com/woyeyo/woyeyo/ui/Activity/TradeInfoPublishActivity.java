package com.woyeyo.woyeyo.ui.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.adapter.SquarePageAdapter;
import com.woyeyo.woyeyo.adapter.TradeInfoAdpater;
import com.woyeyo.woyeyo.ui.fragment.BuyFragment;
import com.woyeyo.woyeyo.ui.fragment.PublishBuyFragment;
import com.woyeyo.woyeyo.ui.fragment.PublishSellFragment;
import com.woyeyo.woyeyo.ui.fragment.SellFragment;

import java.util.ArrayList;

public class TradeInfoPublishActivity extends KBaseActivity {
    private ViewPager viewPager;
    private TextView textViewBuy,textViewSell;
    private ArrayList<Fragment> fragments;
    private PublishBuyFragment buyFragment;
    private PublishSellFragment sellFragment;
    //TODO get tradeId from intent
    private LinearLayout sellLayout;
    private LinearLayout buyLayout;
    @Override
    public void setResId(){
        mainResId= R.layout.activity_trade_info_publish;
    }
    @Override
    public void setToolBarTitle(){
        title=R.string.trade_info_need_title;
    }
    @Override
    public void initSpecialView(){
        fragments=new ArrayList<Fragment>();
        InitTextView();
        InitViewPager();
    }
    private void InitTextView() {
        sellLayout=(LinearLayout)findViewById(R.id.sellLayout);
        buyLayout=(LinearLayout)findViewById(R.id.buyLayout);
        textViewBuy = (TextView) findViewById(R.id.textBuy);
        textViewSell = (TextView) findViewById(R.id.textSell);

        textViewBuy.setOnClickListener(new MyOnClickListener(0));
        textViewSell.setOnClickListener(new MyOnClickListener(1));

        sellLayout.setOnClickListener(new MyOnClickListener(1));
        buyLayout.setOnClickListener(new MyOnClickListener(0));

        buyLayout.setBackgroundColor(
                getResources().getColor(R.color.md_deep_orange_400));

    }
    private void InitViewPager() {
        viewPager = (ViewPager) findViewById(R.id.vPager);
        buyFragment=new PublishBuyFragment();
        sellFragment=new PublishSellFragment();
        fragments.add(buyFragment);
        fragments.add(sellFragment);
        SquarePageAdapter squarePageAdapter=new SquarePageAdapter(
                getSupportFragmentManager(),fragments);
        viewPager.setAdapter(squarePageAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        buyLayout.setBackgroundColor(
                                getResources().getColor(R.color.md_deep_orange_400));
                        sellLayout.setBackgroundColor(
                                getResources().getColor(R.color.md_deep_orange_100));


                        break;
                    case 1:
                        buyLayout.setBackgroundColor(
                                getResources().getColor(R.color.md_deep_orange_100));
                        sellLayout.setBackgroundColor(
                                getResources().getColor(R.color.md_deep_orange_400));
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private class MyOnClickListener implements View.OnClickListener {
        private int index = 0;
        public MyOnClickListener(int i){
            index = i;
        }
        public void onClick(View v) {
            //只能index为0/1
            if(index == 0&&viewPager.getCurrentItem()!=0) {
                buyLayout.setBackgroundColor(getResources().getColor(R.color.md_deep_orange_100));
                sellLayout.setBackgroundColor(getResources().getColor(R.color.md_deep_orange_400));
                viewPager.setCurrentItem(index);




            }
            else if(index == 1&&viewPager.getCurrentItem()!=1){
                buyLayout.setBackgroundColor(getResources().getColor(R.color.md_deep_orange_400));
                sellLayout.setBackgroundColor(getResources().getColor(R.color.md_deep_orange_100));
                viewPager.setCurrentItem(index);
            }
        }
    }
}
