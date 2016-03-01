package com.woyeyo.woyeyo.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by fam_000 on 2016/2/27.
 */
public class SquarePageAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragmentList;
    public SquarePageAdapter(FragmentManager fragmentManager,
                              ArrayList<Fragment> fragmentList) {
        super(fragmentManager);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int positon){
        return fragmentList.get(positon);
    }
    @Override
    public int getCount() {
        return  fragmentList.size();
    }

}
