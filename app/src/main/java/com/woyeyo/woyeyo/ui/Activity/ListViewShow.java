package com.woyeyo.woyeyo.ui.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.melnykov.fab.FloatingActionButton;
import com.melnykov.fab.ScrollDirectionListener;
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

public class ListViewShow extends AppCompatActivity implements SellView {
    private PtrFrameLayout ptrFrameLayout;
    private long  tradeId;
    //TODO get tradeName from intent
    private ListView listView;
    private boolean hasLoaded=false;
    private View parentView;
    private View footView;
    private RelativeLayout titleBar;
    private TextView titleText;
    private RelativeLayout loading;
    private RelativeLayout isLoading;
    private LayoutInflater inflater;
    private List<TradeInfo> tradeInfoList=new ArrayList<TradeInfo>();
    private TradeInfoAdpater tradeInfoAdpater;
    private TradeInfoPresenter tradeInfoPresenter;
    int lastItem;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_tradeinfo_listview);
        inflater=LayoutInflater.from(this);
        listView=(ListView)findViewById(R.id.my_ListView);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.attachToListView(listView);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                listView.setSelection(0);
            }
        });



//        titleBar = (RelativeLayout) findViewById(R.id.title);
//        titleText=(TextView)findViewById(R.id.title_text);
//        titleText.setText(R.string.tradeSquare);

        footView=inflater.inflate(R.layout.foot_view, null);
        loading=(RelativeLayout)footView.findViewById(R.id.loading);
        isLoading=(RelativeLayout)footView.findViewById(R.id.isLoading);
        listView.addFooterView(footView);

        tradeInfoAdpater=new TradeInfoAdpater(this);//warn!
        tradeInfoPresenter=new TradeInfoPresenter(this);

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                   fab.show();
                    if (view.getLastVisiblePosition() == view.getCount()-1) {
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
               // fab.hide();

            }
        });

        ptrFrameLayout=(PtrFrameLayout)findViewById(
                R.id.material_style_ptr_frame);
        ptrFrameLayout.disableWhenHorizontalMove(true);
        final MaterialHeader header = new MaterialHeader(ListViewShow.this);
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
        getNewData();
//        titleBar.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View view){
//                listView.setSelection(0);
//            }
//        });
    }






    @Override
    public void toPullFresh(List<TradeInfo> tradeInfoList){
        tradeInfoAdpater.setItems(tradeInfoList);
        listView.setAdapter(tradeInfoAdpater);
        ptrFrameLayout.refreshComplete();
        Clog.d("f","pull fresh!");
    }
    @Override
    public void toLoadMore(List<TradeInfo> tradeInfoList) {
        tradeInfoAdpater.addItem(tradeInfoList);
        tradeInfoAdpater.notifyDataSetChanged();
        loading.setVisibility(View.GONE);
    }
    @Override
    public void showFailedError(){
        Toast.makeText(ListViewShow.this,"show error",Toast.LENGTH_SHORT).show();
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
