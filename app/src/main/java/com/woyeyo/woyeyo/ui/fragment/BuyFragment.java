package com.woyeyo.woyeyo.ui.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.melnykov.fab.FloatingActionButton;
import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.bean.TradeInfo;
import com.woyeyo.woyeyo.adapter.TradeInfoAdpater;
import com.woyeyo.woyeyo.presenter.TradeInfoPresenter;
import com.woyeyo.woyeyo.utils.Clog;
import com.woyeyo.woyeyo.view.SellView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.MaterialHeader;

public class BuyFragment extends TradeSquareFragment implements SellView {

    @Override
    public void toPullFresh(List<TradeInfo> tradeInfoList){
        tradeInfoAdpater.setItems(tradeInfoList);
        listView.setAdapter(tradeInfoAdpater);
        ptrFrameLayout.refreshComplete();
    }
    @Override
    public void toLoadMore(List<TradeInfo> tradeInfoList) {
        tradeInfoAdpater.addItem(tradeInfoList);
        tradeInfoAdpater.notifyDataSetChanged();
        loading.setVisibility(View.GONE);
    }
    @Override
    public void showFailedError(){
        Toast.makeText(getActivity(),"show error",Toast.LENGTH_SHORT).show();
    }
    protected void loadData() {
        loading.setVisibility(View.GONE);
        isLoading.setVisibility(View.VISIBLE);
        load();
    }
    protected void load() {
        int count=tradeInfoAdpater.getCount()+1;
        tradeInfoPresenter.getInfoIntoView(tradeId, count);
    }
    private void getNewData(){
        tradeInfoPresenter.getInfoIntoView(tradeId, 0);
    }
}
