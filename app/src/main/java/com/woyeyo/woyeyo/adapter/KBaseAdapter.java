package com.woyeyo.woyeyo.adapter;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

/**
 * Created by fam_000 on 2016/2/25.
 */
public abstract class KBaseAdapter<T> extends BaseAdapter {
    protected Context context;
    protected LayoutInflater inflater;
    protected List<T> itemList = new ArrayList<T>();

    public KBaseAdapter(Context context){
        this.context=context;
        inflater=LayoutInflater.from(context);
    }
    public boolean isEmpty(){
        return itemList.isEmpty();
    }
    public void addItem(List<T> itemList){
        this.itemList.addAll(itemList);
        Timber.d("addItemList");
    }

}
