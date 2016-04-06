package com.woyeyo.woyeyo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    public void addItem(List<T> newList){
        itemList.addAll(newList);
        notifyDataSetChanged();
    }
    public void setItems(List<T> itemList){
        this.itemList.clear();
        this.itemList=itemList;
        notifyDataSetChanged();
    }
    public void clearItems(){
        itemList.clear();
    }
    @Override
    public int getCount(){
        return itemList.size();
    }
    @Override
    public Object getItem(int position){
        return itemList.get(position);
    }
    @Override
    public long getItemId(int positon){
        return positon;
    }
    @Override
    abstract public View getView(int position,View convertview,ViewGroup parent);
}
