package com.woyeyo.woyeyo.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.bean.Coupon;
import com.woyeyo.woyeyo.utils.AutoScrollViewPager;
import com.woyeyo.woyeyo.utils.UrlConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fam_000 on 2016/3/6.
 */
public class CouponAdapter extends KBaseAdapter<Coupon> {
    private String slogan;
    private List<String> scrollImgs=new ArrayList<String>();
    private int topId;
    private int scrollImageTopId;
    public CouponAdapter(Context context){
        super(context);
    }
    @Override
    public int getItemViewType(int position){
        if(position==0){
            return 0;
        }else if(position ==1){
            return 1;
        }
        else {
            return 2;
        }
    }
    @Override
    public int getViewTypeCount(){
        return 3;
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        View view=null;
        if (getItemViewType(position) == 2) {
            ViewHolder viewHolder;
            if (convertView == null) {
                view = LayoutInflater.from(context).inflate(R.layout.coupon_item, null);
                viewHolder = new ViewHolder();
                viewHolder.imageView = (ImageView) view.findViewById(R.id.coupon_item_imageView);
                viewHolder.textView = (TextView) view.findViewById(R.id.coupon_item_textView);
                view.setTag(viewHolder);
            } else {
                view = convertView;
                viewHolder = (ViewHolder) view.getTag();
            }
            Coupon coupon = itemList.get(position);
            viewHolder.textView.setText(coupon.getCouponDesc());
            displayCouponImage(coupon, viewHolder);
        } else if(getItemViewType(position) == 1) {
            view=LayoutInflater.from(context).inflate(R.layout.coupon_slogan_item, null);
            TextView textView = (TextView)view.findViewById(R.id.coupon_item_slogan);
            textView.setText(slogan);
        } else if(getItemViewType(position)==0){
            ViewPagerHolder viewPagerHolder=null;
            if(convertView==null){
                view=LayoutInflater.from(context).inflate(R.layout.test_scroll_view,null);
                AutoScrollViewPager pager=(AutoScrollViewPager)view.findViewById(R.id.scroll_pager);
                ScrollViewPageAdapter viewPageAdapter=new ScrollViewPageAdapter(scrollImgs);
                pager.setAdapter(viewPageAdapter);
                pager.setScrollFactor(5);
                pager.setOffscreenPageLimit(4);
                pager.startAutoScroll(2000);
                pager.setOnPageClickListener(new AutoScrollViewPager.OnPageClickListener() {
                    @Override
                    public void onPageClick(AutoScrollViewPager autoScrollPager, int position) {
                    }
                });
            } else{
                view=convertView;
                viewPagerHolder=(ViewPagerHolder)view.getTag();
            }
        }
        return view;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
    class ViewPagerHolder{
        ViewPager viewPager;
    }
    public void displayCouponImage(Coupon coupon,ViewHolder viewHolder){
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisk(true).imageScaleType(ImageScaleType.IN_SAMPLE_INT).build();
        ImageLoader.getInstance().displayImage(
                coupon.getCouponImageUrl(),viewHolder.imageView,options);
    }
    public void setSlogan(String slogan){
        this.slogan=slogan;
    }
    public void setScrollImgs(List<String> scrollImgs){this.scrollImgs=scrollImgs;}
    public int getCouponTopId(){
        //TODO: 加入获取listview 第一个Coupon的ID
        topId=1;
        return topId;
    }
    public int getScrollImgTopId(){
        scrollImageTopId=1;
        return scrollImageTopId;
    }
    public String getSlogan(){
        return slogan;
    }
}
