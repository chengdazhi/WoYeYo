package com.woyeyo.woyeyo.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by fam_000 on 2016/2/27.
 */
public class MyViewPagerAdapter extends PagerAdapter{
    private List<View> mListViews;

    public MyViewPagerAdapter(List<View> mListViews) {
        this.mListViews = mListViews;
    }
    public View getItem(int positon){
        return mListViews.get(positon);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) 	{
        container.removeView(mListViews.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //Log.d("dongbaishun", "container=null?" + (container == null) + "; View=null?" + (mListViews.get(position) == null));
        //Log.d("dongbaishun", "mListViews count:" + mListViews.size() + "; position=" + position);
        container.addView(mListViews.get(position), 0);
        return mListViews.get(position);
    }

    @Override
    public int getCount() {
        return  mListViews.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0==arg1;
    }

}
