package com.woyeyo.woyeyo.ui.fragment;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.adapter.CategoryCouponAdapter;
import com.woyeyo.woyeyo.bean.Coupon;
import com.woyeyo.woyeyo.presenter.CategoryCouponPresenter;
import com.woyeyo.woyeyo.ui.Activity.CategoryCouponActivity;
import com.woyeyo.woyeyo.view.ICategoryCouponView;

import java.util.List;

/**
 * Created by fam_000 on 2016/3/12.
 */
public class CategoryFragment extends  BaseListViewFragment implements ICategoryCouponView{
    private CategoryCouponAdapter adapter;
    private CategoryCouponPresenter presenter;
    private long couponTopId;
    private String category;
    //TODO:get category from intent
    @Override
    public void initFactorsAtFirst(){
        category=getActivity().getIntent().getStringExtra("category");
    }
    protected void inflateViewFromResource(){
        view = inflater.inflate(R.layout.test_tradeinfo_listview, container, false);
    }
    protected void initListViewFromResource(){
        listView = (ListView) view.findViewById(R.id.my_ListView);
    }
    protected void initAdapter(){
        adapter = new CategoryCouponAdapter(context);
    }
    protected void initPrensenter(){
        presenter = new CategoryCouponPresenter(this);
    }
    protected void load() {
        int count=adapter.getCount()+1;
        couponTopId=adapter.getCouponTopId();
        presenter.getInfoIntoView(couponTopId,category,count);
    }
    protected void getNewData(){
        couponTopId=adapter.getCouponTopId();
        presenter.getInfoIntoView(couponTopId,category,0);
    }
    @Override
    public void toPullFresh(List<Coupon> list){
        adapter.setItems(list);
        listView.setAdapter(adapter);

        ptrFrameLayout.refreshComplete();
    }
    @Override
    public void toLoadMore(List<Coupon> list) {
        adapter.addItem(list);
        adapter.notifyDataSetChanged();
        loading.setVisibility(View.GONE);
    }
    @Override
    public void showFailedError(){
        Toast.makeText(getActivity(), "show error", Toast.LENGTH_SHORT).show();
    }

}
