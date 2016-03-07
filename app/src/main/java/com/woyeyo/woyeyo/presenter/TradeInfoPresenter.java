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
public class TradeInfoPresenter implements BaseListPresenter{
    private SellView sellView;
    private GetTrade getTrade;
    private Handler mHandler=new Handler();
    public TradeInfoPresenter(com.woyeyo.woyeyo.view.SellView sellView){
        this.sellView=sellView;
        this.getTrade=new GetTradeInfo();
    }
    public void getInfoIntoView(long tradeId, final int itemCount){
        getTrade.getTradeInfo(tradeId,itemCount,new OnInfoListener() {
            @Override
            public void getInfoSuccess(final List tradeInfoList) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(itemCount==0){
                            sellView.toPullFresh(tradeInfoList);
                        }
                        else{
                            sellView.toLoadMore(tradeInfoList);
                        }
                    }
                });
            }

            @Override
            public void getInfoFailed() {
                sellView.showFailedError();
            }
        });
    }

}
