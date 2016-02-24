package com.woyeyo.woyeyo.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.bean.TradeInfo;
import com.woyeyo.woyeyo.utils.BitmapResource;

import java.util.List;

/**
 * Created by fam_000 on 2016/2/24.
 */
public class TradeInfoAdpater extends ArrayAdapter<TradeInfo> {
    private int resourceid;
    private ViewHolder viewHolder;
    public TradeInfoAdpater(Context context,int myResourceid,List<TradeInfo> objects){
        super(context,myResourceid,objects);
        resourceid=myResourceid;
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        TradeInfo tradeInfo=getItem(position);
        ViewHolder viewHolder;
        View view;
        if(convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourceid,null);
            viewHolder=new ViewHolder();
            viewHolder.description=(TextView)view.findViewById(R.id.good_detail_description_sell);
            viewHolder.price=(TextView)view.findViewById(R.id.good_description_sell_price);
            viewHolder.Photo=(ImageView)view.findViewById(R.id.good_description_sell_user_image);
            viewHolder.Star=(ImageView)view.findViewById(R.id.good_description_sell_user_star);
            view.setTag(viewHolder);
        }
        else{
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
        viewHolder.description.setText(tradeInfo.getDescription());
        viewHolder.price.setText(tradeInfo.getPrice());
        viewHolder.Photo.setImageBitmap(tradeInfo.getPhoto());
        int StarNum=tradeInfo.getStarNum();
        //TODO switch starNum to drawable star
        viewHolder.Star.setImageBitmap(BitmapResource.getBitmapFromResource(R.drawable.fivestar));
        return view;
    }
    class ViewHolder{
        ImageView Photo;
        ImageView Star;
        TextView description;
        TextView price;
    }


}
