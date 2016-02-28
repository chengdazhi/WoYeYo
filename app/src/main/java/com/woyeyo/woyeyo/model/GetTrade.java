package com.woyeyo.woyeyo.model;

import com.woyeyo.woyeyo.presenter.OnTradeInfoListener;

/**
 * Created by fam_000 on 2016/2/24.
 */
public interface GetTrade {
    void getTradeInfo(final long tradeId,int itemCount,OnTradeInfoListener listener );
}
