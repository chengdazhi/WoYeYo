package com.woyeyo.woyeyo.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.woyeyo.woyeyo.R;

/**
 * Created by fam_000 on 2016/3/6.
 */
public class MainPageFragment extends TradeSquareFragment {
    private View headView;
    @Override
    public void initListView(LayoutInflater inflater){
        listView = (ListView) view.findViewById(R.id.my_ListView);
        footView = inflater.inflate(R.layout.foot_view, null);
        headView=inflater.inflate(R.layout.test_scroll_view_fragment,null);
        loading = (RelativeLayout) footView.findViewById(R.id.loading);
        isLoading = (RelativeLayout) footView.findViewById(R.id.isLoading);
        listView.addFooterView(footView);
        listView.addHeaderView(headView);
    }
}
