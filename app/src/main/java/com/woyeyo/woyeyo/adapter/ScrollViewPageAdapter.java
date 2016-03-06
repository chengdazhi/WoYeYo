package com.woyeyo.woyeyo.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

/**
 * Created by fam_000 on 2016/3/6.
 */
public class ScrollViewPageAdapter extends PagerAdapter {
    private String[] imgs;
    private DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
            .cacheOnDisk(true).imageScaleType(ImageScaleType.IN_SAMPLE_INT).build();
    public ScrollViewPageAdapter(String[] imgs){
        this.imgs=imgs;
    }
    @Override
    public int getCount(){
        return imgs.length;
    }
    @Override
    public boolean isViewFromObject(View view,Object o){
        return view==o;
    }
    @Override
    public Object instantiateItem(ViewGroup container,int position){
        ImageView view=new ImageView(container.getContext());
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ImageLoader.getInstance().displayImage(imgs[position], view, options);
        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container,int position,Object object){
        container.removeView((View)object);
    }

}
