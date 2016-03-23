package com.woyeyo.woyeyo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.bean.TradeInfo;
import com.woyeyo.woyeyo.presenter.TradeInfoPresenter;
import com.woyeyo.woyeyo.utils.BitmapResource;

/**
 * Created by fam_000 on 2016/2/25.
 */
public class LoadeMore_TradeInfoAdapter extends KBaseAdapter<TradeInfo>{
    public LoadeMore_TradeInfoAdapter(Context context){
        super(context);
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        ViewHolder viewHolder;
        View view;
        if(convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.trade_info_item,null);
            viewHolder=new ViewHolder();
            viewHolder.description=(TextView)view.findViewById(R.id.good_detail_description_sell);
            viewHolder.price=(TextView)view.findViewById(R.id.good_description_sell_price);
            viewHolder.Photo=(ImageView)view.findViewById(R.id.good_description_sell_user_image);
            viewHolder.Star=(ImageView)view.findViewById(R.id.good_description_sell_user_star);
            view.setTag(viewHolder);
        }
        else   {
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
        TradeInfo tradeInfo=itemList.get(position);
        viewHolder.description.setText(tradeInfo.getDescription());
        viewHolder.price.setText(tradeInfo.getPrice());
        viewHolder.Photo.setImageBitmap(tradeInfo.getPhoto());
        int StarNum=tradeInfo.getStarNum();
        //TODO switch starNum to drawable star
        viewHolder.Star.setImageBitmap(BitmapResource.getBitmapFromResource(R.drawable.fivestar));
        return view;
    }
    private class ViewHolder{
        ImageView Photo;
        ImageView Star;
        TextView description;
        TextView price;
    }
}
