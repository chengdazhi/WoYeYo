package com.woyeyo.woyeyo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.bean.Address;

/**
 * Created by fam_000 on 2016/3/19.
 */
public class AddressAdapter extends KBaseAdapter<Address> {
    public AddressAdapter(Context context){
        super(context);
    }
    @Override
    public View getView(int positon,View convertView,ViewGroup parent){
        View view=null;
        ViewHolder viewHolder;
        if(convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.address_item,null);
            viewHolder=new ViewHolder();
            viewHolder.name=(TextView)view.findViewById(R.id.name);
            viewHolder.address=(TextView)view.findViewById(R.id.address);
            viewHolder.number=(TextView)view.findViewById(R.id.number);
            view.setTag(viewHolder);
        }else {
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
        Address address=itemList.get(positon);
        viewHolder.name.setText(address.getName());
        viewHolder.number.setText(address.getPhone());
        viewHolder.address.setText(address.getAddressDetail());
        return view;
    }
    private class ViewHolder{
        TextView name;
        TextView number;
        TextView address;
    }
}
