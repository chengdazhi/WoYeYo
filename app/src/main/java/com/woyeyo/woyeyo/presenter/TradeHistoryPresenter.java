package com.woyeyo.woyeyo.presenter;

import android.os.Handler;

import com.woyeyo.woyeyo.bean.Trade;
import com.woyeyo.woyeyo.model.GetTrade;
import com.woyeyo.woyeyo.model.GetTradeInfo;
import com.woyeyo.woyeyo.utils.Token;
import com.woyeyo.woyeyo.view.IGetInfoView;
import com.woyeyo.woyeyo.view.IGetListInfoView;
import com.woyeyo.woyeyo.view.IListView;

import java.util.List;

/**
 * Created by fam_000 on 2016/3/22.
 */

public class TradeHistoryPresenter {
    private IListView<Trade> iGetInfoView;
    private GetTrade iGetTrade;
    private Handler mHandler=new Handler();
    public TradeHistoryPresenter(IListView<Trade> iGetInfoView){
        this.iGetInfoView=iGetInfoView;
        iGetTrade=new GetTradeInfo();
    }
    public void getInfointoView(final int itemCount){
        iGetTrade.getTradeHistory(itemCount,new OnInfoListener() {
            @Override
            public void getInfoSuccess(final List list) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (itemCount == 0) {
                            iGetInfoView.toPullFresh(list);
                        } else {
                            iGetInfoView.toLoadMore(list);
                        }
                    }
                });
            }

            @Override
            public void getInfoFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iGetInfoView.showFailedError();
                    }
                });
            }
        });

    }
}
