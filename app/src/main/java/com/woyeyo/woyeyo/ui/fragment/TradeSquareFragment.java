package com.woyeyo.woyeyo.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.melnykov.fab.FloatingActionButton;
import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.bean.Trade;
import com.woyeyo.woyeyo.bean.TradeInfo;
import com.woyeyo.woyeyo.adapter.TradeInfoAdpater;
import com.woyeyo.woyeyo.presenter.TradeInfoPresenter;
import com.woyeyo.woyeyo.utils.Clog;
import com.woyeyo.woyeyo.utils.ToastUtil;
import com.woyeyo.woyeyo.view.SellView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.MaterialHeader;

public class TradeSquareFragment extends BaseListViewFragment implements SellView {
    protected long  tradeId;
    //TODO get tradeName from intent
    protected TradeInfoAdpater tradeInfoAdpater;
    protected TradeInfoPresenter tradeInfoPresenter;
    @Override
    protected void inflateViewFromResource(){
        view=inflater.inflate(R.layout.test_tradeinfo_listview,container,false);
    }
    @Override
    protected void initPresenter(){
        tradeInfoPresenter=new TradeInfoPresenter(TradeSquareFragment.this);
    }
    @Override
    protected void initAdapter(){
        tradeInfoAdpater=new TradeInfoAdpater(context);
    }
    @Override
    protected void initListViewFromResource(){
        listView=(ListView)view.findViewById(R.id.my_ListView);
    }
    @Override
    protected void initOnItemClickListener(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TradeInfo tradeInfo=(TradeInfo)listView.getAdapter().getItem(position);
                ToastUtil.KToast(context,tradeInfo.getPersonId()+"");

            }
        });
    }
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
        isLoadMore=false;
    }
    @Override
    public void showFailedError(){
        Toast.makeText(getActivity(),"show error",Toast.LENGTH_SHORT).show();
    }
    protected void load() {
        int count=tradeInfoAdpater.getCount();
        tradeInfoPresenter.getInfoIntoView(tradeId, count);
    }
    protected void getNewData(){
        tradeInfoPresenter.getInfoIntoView(tradeId, 0);
    }
}
