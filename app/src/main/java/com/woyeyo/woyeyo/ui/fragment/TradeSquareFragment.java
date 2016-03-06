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

public class TradeSquareFragment extends Fragment implements SellView {
    protected PtrFrameLayout ptrFrameLayout;
    protected long  tradeId;
    //TODO get tradeName from intent
    protected ListView listView;
    protected boolean hasLoaded=false;
    protected View parentView;
    protected View footView;
    protected RelativeLayout titleBar;
    protected TextView titleText;
    protected RelativeLayout loading;
    protected RelativeLayout isLoading;
    protected LayoutInflater inflater;
    protected List<TradeInfo> tradeInfoList=new ArrayList<TradeInfo>();
    protected TradeInfoAdpater tradeInfoAdpater;
    protected TradeInfoPresenter tradeInfoPresenter;
    protected int lastItem;
    protected Context context;
    protected View view;
    protected FloatingActionButton fab;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle saveInstanceState) {
        context = getActivity();
        view = inflater.inflate(R.layout.test_tradeinfo_listview, container, false);
        super.onCreate(saveInstanceState);
        initListView(inflater);
        initFloatButton();
        tradeInfoAdpater=new TradeInfoAdpater(context);//warn!

        tradeInfoPresenter = new TradeInfoPresenter(this);

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    fab.show();
                    if (view.getLastVisiblePosition() == view.getCount() - 1) {
                        loadData();
                    }
                }
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_FLING) {
                    fab.hide();
                }
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    //  fab.hide(false);
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                lastItem = firstVisibleItem + visibleItemCount - 1;
            }
        });
        initPulltoFresh();
        getNewData();
        return view;
    }
    public void initListView(LayoutInflater inflater){
        listView = (ListView) view.findViewById(R.id.my_ListView);
        footView = inflater.inflate(R.layout.foot_view, null);
        loading = (RelativeLayout) footView.findViewById(R.id.loading);
        isLoading = (RelativeLayout) footView.findViewById(R.id.isLoading);
        listView.addFooterView(footView);
    }
    public void initFloatButton(){
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.attachToListView(listView);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                listView.setSelection(0);
            }
        });
    }
//    public void initTitle(){
//        titleBar = (RelativeLayout) view.findViewById(R.id.title);
//        titleText = (TextView) view.findViewById(R.id.title_text);
//        titleText.setText(R.string.tradeSquare);
//        titleBar.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                listView.setSelection(0);
//            }
//        });
//    }
    public void initPulltoFresh(){
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
        tradeInfoPresenter.getTradeInfointoView(tradeId, count);
    }
    private void getNewData(){
        tradeInfoPresenter.getTradeInfointoView(tradeId, 0);
    }
}
