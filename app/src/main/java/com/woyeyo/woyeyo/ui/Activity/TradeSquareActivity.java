package com.woyeyo.woyeyo.ui.Activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.adapter.MyViewPagerAdapter;
import com.woyeyo.woyeyo.adapter.TradeInfoAdpater;
import com.woyeyo.woyeyo.bean.TradeInfo;
import com.woyeyo.woyeyo.presenter.TradeInfoPresenter;
import com.woyeyo.woyeyo.view.SellView;

import java.util.ArrayList;
import java.util.List;

public class TradeSquareActivity extends AppCompatActivity implements SellView{

    private ViewPager viewPager;
    private TextView textViewBuy,textViewSell;
    private List<View> views;
    private int currIndex = 0;
    private View viewBuy, viewSell;
    private long tradeId;
    //TODO get tradeName from intent
    private LinearLayout sellLayout;
    private LinearLayout buyLayout;
    private ListView buyListView;
    private ListView sellListView;
    private List<TradeInfo> tradeInfoList=new ArrayList<TradeInfo>();
    private TradeInfoAdpater buyInfoAdpater;
    private TradeInfoAdpater sellInfoAdapter;
    private Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade_square);
        InitTextView();
        InitViewPager();
        buyInfoAdpater=new TradeInfoAdpater(TradeSquareActivity.this);
        sellInfoAdapter=new TradeInfoAdpater(TradeSquareActivity.this);
        TradeInfoPresenter tradeInfoPresenter=new TradeInfoPresenter(this);
        tradeInfoPresenter.getTradeInfointoView(tradeId,0);
    }
    private void InitTextView() {
        sellLayout=(LinearLayout)findViewById(R.id.sellLayout);
        buyLayout=(LinearLayout)findViewById(R.id.buyLayout);
        textViewBuy = (TextView) findViewById(R.id.textBuy);
        textViewSell = (TextView) findViewById(R.id.textSell);
        sellLayout.setOnClickListener(new MyOnClickListener(0));
        buyLayout.setOnClickListener(new MyOnClickListener(1));

    }
    private void InitViewPager() {
        viewPager = (ViewPager) findViewById(R.id.vPager);
        views = new ArrayList<View>();
        LayoutInflater inflater=getLayoutInflater();
        viewBuy = inflater.inflate(R.layout.activity_trade_square_buy, null);
        viewSell = inflater.inflate(R.layout.activity_trade_square_sell, null);
        buyListView=(ListView)viewBuy.findViewById(R.id.BuyListView);
        sellListView=(ListView)viewSell.findViewById(R.id.SellListView);//warn！
        views.add(viewBuy);
        views.add(viewSell);
        MyViewPagerAdapter myViewPagerAdapter=new MyViewPagerAdapter(views);
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        buyLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                        sellLayout.setBackgroundColor(getResources().getColor(R.color.lightcyan));
                        break;
                    case 1:
                        buyLayout.setBackgroundColor(getResources().getColor(R.color.lightcyan));
                        sellLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
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
            if(index ==0) {
                buyLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                sellLayout.setBackgroundColor(getResources().getColor(R.color.lightcyan));
                viewPager.setCurrentItem(index);
            }
            else if(index == 1){
                buyLayout.setBackgroundColor(getResources().getColor(R.color.lightcyan));
                sellLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                viewPager.setCurrentItem(index);
            }
            else {
                //Toast.makeText(TradeSquareActivity.this, "index Error", Toast.LENGTH_SHORT).show();
                Toast.makeText(TradeSquareActivity.this, "对不起，切换失败", Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    public void toPullFresh(List<TradeInfo> tradeInfoList){
        buyInfoAdpater.addItem(tradeInfoList);
        sellInfoAdapter.addItem(tradeInfoList);
        sellListView.setAdapter(buyInfoAdpater);
        buyListView.setAdapter(sellInfoAdapter);
    }
    @Override
    public void toLoadMore(List<TradeInfo> tradeInfoList){

    }
    @Override
    public void showFailedError(){
        Toast.makeText(TradeSquareActivity.this,"show error",Toast.LENGTH_SHORT).show();
    }

}