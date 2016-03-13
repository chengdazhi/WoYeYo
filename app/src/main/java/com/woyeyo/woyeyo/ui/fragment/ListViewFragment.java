package com.woyeyo.woyeyo.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.woyeyo.woyeyo.R;

/**
 * Created by fam_000 on 2016/2/29.
 */
public class ListViewFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle saveInstanceState){
        return inflater.inflate(R.layout.trade_info_listview,container,false);
    }

}
