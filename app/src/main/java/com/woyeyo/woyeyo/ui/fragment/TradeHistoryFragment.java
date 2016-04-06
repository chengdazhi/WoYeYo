package com.woyeyo.woyeyo.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.adapter.TradeHistoryAdapter;
import com.woyeyo.woyeyo.bean.Trade;
import com.woyeyo.woyeyo.presenter.TradeHistoryPresenter;
import com.woyeyo.woyeyo.utils.Clog;
import com.woyeyo.woyeyo.view.IListView;

import java.util.List;

/**
 * Created by fam_000 on 2016/3/20.
 */
public class TradeHistoryFragment extends BaseListViewFragment implements IListView<Trade>{
    private TradeHistoryPresenter presenter;
    private TradeHistoryAdapter adapter;
    protected void inflateViewFromResource(){
        view = inflater.inflate(R.layout.fragment_trade_history, container, false);
    }
    protected void initListViewFromResource(){
        listView = (ListView) view.findViewById(R.id.my_ListView);
    }

    protected void initAdapter(){
        adapter=new TradeHistoryAdapter(context);
    }
    @Override
    public void initOnItemClickListener(){
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO:write a tradeDetailActivity
//                Trade trade=(Trade)listView.getAdapter().getItem(position);
//                long sendId=trade.getTradeId();
//                Intent sendIntent=new Intent(context, CouponDetailActivity.class);
//                sendIntent.putExtra("tradeId",sendId);
//                context.startActivity(sendIntent);
//            }
//        });
    }
    protected void initPresenter(){
        presenter=new TradeHistoryPresenter(TradeHistoryFragment.this);
    }
    protected void load() {
        Clog.d("fragment","load");
        int count=adapter.getCount();
        presenter.getInfointoView(count);
    }
    protected void getNewData(){
        Clog.d("fragment","get new data");
        //adapter.clearItems();
        presenter.getInfointoView(0);
    }
    @Override
    public void toPullFresh(List<Trade> list){
        adapter.setItems(list);
        listView.setAdapter(adapter);
        ptrFrameLayout.refreshComplete();
    }
    @Override
    public void toLoadMore(List<Trade> list) {
        adapter.addItem(list);
        loading.setVisibility(View.GONE);
        isLoadMore=false;
    }
    @Override
    public void showFailedError(){
        Toast.makeText(getActivity(), "show error", Toast.LENGTH_SHORT).show();
    }
}
