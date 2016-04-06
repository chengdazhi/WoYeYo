package com.woyeyo.woyeyo.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.melnykov.fab.FloatingActionButton;
import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.adapter.KBaseAdapter;
import com.woyeyo.woyeyo.bean.TradeInfo;
import com.woyeyo.woyeyo.presenter.BaseListPresenter;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.MaterialHeader;

/**
 * Created by fam_000 on 2016/3/7.
 */
public abstract class BaseListViewFragment extends Fragment{
    protected PtrFrameLayout ptrFrameLayout;
    //TODO get tradeName from intent
    protected ListView listView;
    protected boolean hasLoaded=false;
    protected View footView;
    protected RelativeLayout loading;
    protected RelativeLayout isLoading;
    protected int lastItem;
    protected FloatingActionButton fab;
    protected View view;
    protected LayoutInflater inflater;
    protected ViewGroup container;
    protected Context context;

    /***
     *  must set isLoadmore=false in toLoadMore function!!!
     */
    protected boolean isLoadMore;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle saveInstanceState){
        this.inflater=inflater;
        this.container=container;
        inflateViewFromResource();
        return view;
    }

    @Override
    public void onActivityCreated(Bundle saveInsatanceState){
        super.onActivityCreated(saveInsatanceState);
        context = getActivity();

        //you can finish some extra things here by override it as an option
        initFactorsAtFirst();

        initAdapter();
        initPresenter();
        initListViewFromResource();
        initOnItemClickListener();
        initPtrAndLoad(inflater);
        initFloatButton();

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if(scrollState==AbsListView.OnScrollListener.SCROLL_STATE_IDLE){
                    if (!isLoadMore&&view.getLastVisiblePosition() == (view.getCount() - 1)) {
                        isLoadMore=true;
                        loadData();
                    }
                }
//                if (view.getFirstVisiblePosition()>1&&scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
//                    fab.show();
//                }

                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_FLING) {
                    //fab.hide();
                }
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    //  fab.hide(false);
                    fab.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                lastItem = firstVisibleItem + visibleItemCount - 1;

                if(view.getFirstVisiblePosition()<=2){
                    fab.hide();
                }
                if(view.getFirstVisiblePosition()>2){
                    fab.show();
                }
            }
        });

        initPulltoFresh();
        getNewData();
    }
    protected void initOnItemClickListener(){

    }
    protected void initPtrAndLoad(LayoutInflater inflater){
        footView = inflater.inflate(R.layout.foot_view, null);
        loading = (RelativeLayout) footView.findViewById(R.id.loading);
        isLoading = (RelativeLayout) footView.findViewById(R.id.isLoading);
        listView.addFooterView(footView);
    }
    protected void initFloatButton(){
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.attachToListView(listView);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                listView.setSelection(0);
            }
        });

    }
    protected void initPulltoFresh(){
        ptrFrameLayout=(PtrFrameLayout)view.findViewById(
                R.id.material_style_ptr_frame);
        ptrFrameLayout.disableWhenHorizontalMove(true);
        final MaterialHeader header = new MaterialHeader(context);
        //int[] colors = getResources().getIntArray(R.array.google_colors);
        //header.setColorSchemeColors(colors);
        header.setLayoutParams(new PtrFrameLayout.LayoutParams(-1, -2));
        //header.setPadding(0, LocalDisplay.dp2px(15), 0, LocalDisplay.dp2px(10));
        header.setPtrFrameLayout(ptrFrameLayout);
        ptrFrameLayout.setLoadingMinTime(200);
        ptrFrameLayout.setDurationToCloseHeader(100);
        ptrFrameLayout.setHeaderView(header);
        ptrFrameLayout.addPtrUIHandler(header);
        ptrFrameLayout.setPinContent(true);
        ptrFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public void onRefreshBegin(final PtrFrameLayout frame) {
                if (hasLoaded) {
                    frame.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            frame.refreshComplete();
                        }
                    }, 500);
                } else {
                    getNewData();
                }
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                View firstChild = listView.getChildAt(0);
                boolean ableToPush = true;
                if (firstChild != null) {
                    int firstVisiblePos = listView.getFirstVisiblePosition();
                    if (firstVisiblePos == 0 && firstChild.getTop() == 0) {
                        ableToPush = true;
                        // 如果首个元素的上边缘，距离父布局值为0，就说明ListView滚动到了最顶部，此时应该允许下拉刷新
                    } else if (listView.getItemAtPosition(0) == null) {
                        ableToPush = true;
                    } else {
                        ableToPush = false;
                    }
                }
                return ableToPush;
            }
        });
    }
    protected void loadData() {
        loading.setVisibility(View.GONE);
        isLoading.setVisibility(View.VISIBLE);
        load();
    }
    public PtrFrameLayout getPtr(){
        return ptrFrameLayout;
    }
    public ListView getListView(){
        return listView;
    }
    public RelativeLayout getLoading(){
        return loading;
    }
    protected void initFactorsAtFirst(){

    }
    //child class must implement all the abstract method!


    abstract protected void load();
    abstract protected void getNewData();
    abstract protected void inflateViewFromResource();
    abstract protected void initListViewFromResource();
    abstract protected void initAdapter();
    abstract protected void initPresenter();

}
