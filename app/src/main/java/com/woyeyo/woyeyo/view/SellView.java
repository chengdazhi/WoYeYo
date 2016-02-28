package com.woyeyo.woyeyo.view;

import com.woyeyo.woyeyo.bean.TradeInfo;

import java.util.List;

/**
 * Created by fam_000 on 2016/2/24.
 */
public interface SellView {
    void toPullFresh(List<TradeInfo> tradeInfoList);
    void toLoadMore(List<TradeInfo> tradeInfoList);
    void showFailedError();
}
