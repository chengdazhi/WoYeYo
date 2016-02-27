package com.woyeyo.woyeyo.presenter;

import android.os.Handler;
import android.util.Log;

import com.woyeyo.woyeyo.bean.TradeInfo;
import com.woyeyo.woyeyo.model.GetTrade;
import com.woyeyo.woyeyo.model.GetTradeInfo;
import com.woyeyo.woyeyo.view.SellView;

import java.util.List;
import java.util.Timer;

import timber.log.Timber;

/**
 * Created by fam_000 on 2016/2/24.
 */
public class TradeInfoPresenter {
    private SellView sellView;
    private GetTrade getTrade;
    private Handler mHandler=new Handler();
    public TradeInfoPresenter(com.woyeyo.woyeyo.view.SellView sellView){
        this.sellView=sellView;
        this.getTrade=new GetTradeInfo();
    }
    public void getTradeInfointoView(String tradeName){
        getTrade.getTradeInfo(tradeName, new OnTradeInfoListener() {
            @Override
            public void getTradeInfoSuccess(final List tradeInfoList) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("f","a");
                        if(!tradeInfoList.isEmpty()){
                            Log.d("f","bug");
                        }
                        else{
                            Log.d("f", tradeInfoList.get(1).toString());
                        }
                        sellView.toActivity(tradeInfoList);

                    }
                });
            }

            @Override
            public void getTradeInfoFailed() {
                sellView.showFailedError();
            }
        });
    }

}
