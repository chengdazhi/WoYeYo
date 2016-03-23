package com.woyeyo.woyeyo.ui.Activity;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.bean.Trade;
import com.woyeyo.woyeyo.presenter.TradeHistoryPresenter;
import com.woyeyo.woyeyo.view.IGetListInfoView;
import com.woyeyo.woyeyo.view.IListView;

import java.util.List;

/**
 * Created by DongBaishun on 2016/3/19.
 */
public class TradeHistoryActivity extends KBaseActivity {

    public void setResId() {
        mainResId = R.layout.activity_trade_history;
    }

    public void setToolBarTitle() {
        title = R.string.trade_history_title;
    }


}
