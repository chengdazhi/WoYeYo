package com.woyeyo.woyeyo.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.adapter.ScrollViewPageAdapter;
import com.woyeyo.woyeyo.utils.AutoScrollViewPager;
import com.woyeyo.woyeyo.utils.CirclePageIndicator;
import com.woyeyo.woyeyo.utils.UrlConstants;

import java.util.Arrays;

/**
 * Created by fam_000 on 2016/3/5.
 */
public class TestScrollViewFragment extends Fragment {
    private String[] imgs= UrlConstants.ScrollImage;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle saveInstanceState){
        return inflater.inflate(R.layout.test_scroll_view, container, false);
    }
    @Override
    public void onViewCreated(View view,Bundle saveInstanceState){
        super.onViewCreated(view,saveInstanceState);
        AutoScrollViewPager pager=(AutoScrollViewPager)getView().findViewById(R.id.scroll_pager);
        ScrollViewPageAdapter viewPageAdapter=new ScrollViewPageAdapter(Arrays.asList(imgs));
        CirclePageIndicator indicator = (CirclePageIndicator) getView().findViewById(R.id.indicator);
        pager.setAdapter(viewPageAdapter);
        pager.setScrollFactor(5);
        pager.setOffscreenPageLimit(4);
        pager.startAutoScroll(2000);
        pager.setOnPageClickListener(new AutoScrollViewPager.OnPageClickListener() {
            @Override
            public void onPageClick(AutoScrollViewPager autoScrollPager, int position) {
            }
        });
        indicator.setViewPager(pager);
        indicator.setSnap(true);
    }
}
