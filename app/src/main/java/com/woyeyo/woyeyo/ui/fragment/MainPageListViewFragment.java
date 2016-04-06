package com.woyeyo.woyeyo.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.adapter.CouponAdapter;
import com.woyeyo.woyeyo.bean.Coupon;
import com.woyeyo.woyeyo.presenter.CouponListPresenter;
import com.woyeyo.woyeyo.ui.Activity.CouponDetailActivity;
import com.woyeyo.woyeyo.view.ICouponListView;

import java.util.List;

/**
 * Created by fam_000 on 2016/3/8.
 */
public class MainPageListViewFragment extends BaseListViewFragment implements ICouponListView{
    private CouponAdapter couponAdapter;
    private CouponListPresenter couponListPresenter;
    private long couponTopId;
    private long scrollImgTopId;
    protected void inflateViewFromResource(){
        view = inflater.inflate(R.layout.test_tradeinfo_listview, container, false);
    }
    protected void initListViewFromResource(){
        listView = (ListView) view.findViewById(R.id.my_ListView);
    }
    protected void initAdapter(){
        couponAdapter = new CouponAdapter(context);
    }
    @Override
    public void initOnItemClickListener(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Coupon coupon=(Coupon)listView.getAdapter().getItem(position);
                long sendId=coupon.getCouponId();
                Intent sendIntent=new Intent(context, CouponDetailActivity.class);
                sendIntent.putExtra("couponId",sendId);
                context.startActivity(sendIntent);
            }
        });
    }
    protected void initPresenter(){
        couponListPresenter = new CouponListPresenter(this);
    }
    protected void load() {
        int count=couponAdapter.getCount();
        couponTopId=couponAdapter.getCouponTopId();
        scrollImgTopId=couponAdapter.getScrollImgTopId();
        couponListPresenter.getInfoIntoView(couponTopId,scrollImgTopId,count);
    }
    protected void getNewData(){
        couponTopId=couponAdapter.getCouponTopId();
        scrollImgTopId=couponAdapter.getScrollImgTopId();
        couponListPresenter.getInfoIntoView(couponTopId,scrollImgTopId,0);
    }
    @Override
    public void toPullFresh(List<Coupon> list,String slogan,List<String> scrollImgUrl){
        couponAdapter.setItems(list);
        couponAdapter.setSlogan(slogan);
        couponAdapter.setScrollImgs(scrollImgUrl);

        listView.setAdapter(couponAdapter);

        ptrFrameLayout.refreshComplete();
    }
    @Override
    public void toLoadMore(List<Coupon> list) {
        couponAdapter.addItem(list);
        couponAdapter.notifyDataSetChanged();
        loading.setVisibility(View.GONE);
        isLoadMore=false;
    }
    @Override
    public void showFailedError(){
        Toast.makeText(getActivity(), "show error", Toast.LENGTH_SHORT).show();
    }
}
