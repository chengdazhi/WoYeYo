package com.woyeyo.woyeyo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.bean.TradeInfo;
import com.woyeyo.woyeyo.adapter.TradeInfoAdpater;
import com.woyeyo.woyeyo.presenter.TradeInfoPresenter;
import com.woyeyo.woyeyo.view.SellView;

import java.util.ArrayList;
import java.util.List;

public class ListViewShow extends AppCompatActivity implements SellView {
    private String tradeName;
    //TODO get tradeName from intent
    private ListView listView;
    private List<TradeInfo> tradeInfoList=new ArrayList<TradeInfo>();
    private TradeInfoAdpater tradeInfoAdpater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trade_info_listview);
        listView=(ListView)findViewById(R.id.my_ListView);
        tradeInfoAdpater=new TradeInfoAdpater(ListViewShow.this);//warn!
        TradeInfoPresenter tradeInfoPresenter=new TradeInfoPresenter(this);
        tradeInfoPresenter.getTradeInfointoView(tradeName);

    }
    @Override
    public void toActivity(List<TradeInfo> tradeInfoList){
        Log.d("f", "test");
        Log.d("f", tradeInfoList.get(1).toString());
        tradeInfoAdpater.setItems(tradeInfoList);
        listView.setAdapter(tradeInfoAdpater);
    }
    @Override
    public void showFailedError(){
        Toast.makeText(ListViewShow.this,"show error",Toast.LENGTH_SHORT).show();
    }
}
