package com.woyeyo.woyeyo.ui.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.adapter.SquarePageAdapter;
import com.woyeyo.woyeyo.adapter.TradeInfoAdpater;
import com.woyeyo.woyeyo.ui.fragment.BuyFragment;
import com.woyeyo.woyeyo.ui.fragment.SellFragment;
import com.woyeyo.woyeyo.ui.fragment.TradeSquareFragment;

import java.util.ArrayList;

public class TestTradeSquare extends AppCompatActivity{
    private ViewPager viewPager;
    private TextView textViewBuy,textViewSell;
    private ArrayList<Fragment> fragments;
    private int currIndex = 0;
    private BuyFragment buyFragment;
    private SellFragment sellFragment;
    private long tradeId;
    //TODO get tradeId from intent
    private LinearLayout sellLayout;
    private LinearLayout buyLayout;
    private TradeInfoAdpater buyInfoAdpater;
    private TradeInfoAdpater sellInfoAdapter;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade_square);
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
                getResources().getColor(R.color.colorPrimaryDark));

    }
    private void InitViewPager() {
        viewPager = (ViewPager) findViewById(R.id.vPager);
        buyFragment=new BuyFragment();
        sellFragment=new SellFragment();
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
                                getResources().getColor(R.color.colorPrimaryDark));
                        sellLayout.setBackgroundColor(
                                getResources().getColor(R.color.lightcyan));


                        break;
                    case 1:
                        buyLayout.setBackgroundColor(
                                getResources().getColor(R.color.lightcyan));
                        sellLayout.setBackgroundColor(
                                getResources().getColor(R.color.colorPrimaryDark));
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
            if(index == 0) {
                buyLayout.setBackgroundColor(getResources().getColor(R.color.lightcyan));
                sellLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                viewPager.setCurrentItem(index);
            }
            else if(index == 1){
                buyLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                sellLayout.setBackgroundColor(getResources().getColor(R.color.lightcyan));
                viewPager.setCurrentItem(index);
            }
            else {
                //Toast.makeText(TradeSquareActivity.this, "index Error", Toast.LENGTH_SHORT).show();
                Toast.makeText(TestTradeSquare.this, "对不起，切换失败", Toast.LENGTH_SHORT).show();
            }
        }
    }

}