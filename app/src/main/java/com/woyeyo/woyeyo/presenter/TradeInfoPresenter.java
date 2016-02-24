package com.woyeyo.woyeyo.presenter;

import android.os.Handler;

import com.woyeyo.woyeyo.model.GetTrade;
import com.woyeyo.woyeyo.model.GetTradeInfo;
import com.woyeyo.woyeyo.model.OnTradeInfoListener;
import com.woyeyo.woyeyo.view.SellView;

import java.util.List;

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
