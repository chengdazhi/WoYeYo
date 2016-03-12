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

/**
 * Created by fam_000 on 2016/3/12.
 */
public class CategoryCouponAdapter extends KBaseAdapter<Coupon> {
    private int topId;
    public CategoryCouponAdapter(Context context){
        super(context);
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        View view=null;
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
        return view;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
    public void displayCouponImage(Coupon coupon,ViewHolder viewHolder){
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisk(true).imageScaleType(ImageScaleType.IN_SAMPLE_INT).build();
        ImageLoader.getInstance().displayImage(
                coupon.getCouponImageUrl(),viewHolder.imageView,options);
    }
    public int getCouponTopId(){
        //TODO: 加入获取listview 第一个Coupon的ID
        topId=1;
        return topId;
    }

}
