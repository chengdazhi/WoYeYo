package com.woyeyo.woyeyo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.bean.Address;
import com.woyeyo.woyeyo.bean.Trade;
import com.woyeyo.woyeyo.utils.Clog;
import com.woyeyo.woyeyo.utils.ImageUtil;
import com.woyeyo.woyeyo.utils.ToastUtil;

/**
 * Created by fam_000 on 2016/3/20.
 */
public class TradeHistoryAdapter extends KBaseAdapter<Trade> {
    public TradeHistoryAdapter(Context context){
        super(context);
    }
    @Override
    public View getView(int positon,View convertView,ViewGroup parent){

        View view=null;
        final ViewHolder viewHolder;
        if(convertView==null){
            Clog.d("testListview",itemList.size()+" "+positon+"null");
            view= LayoutInflater.from(context).inflate(R.layout.trade_history_item,null);
            viewHolder=new ViewHolder();
            viewHolder.nickname=(TextView)view.findViewById(R.id.nickname);
            viewHolder.desc=(TextView)view.findViewById(R.id.desc);
            viewHolder.price=(TextView)view.findViewById(R.id.price);
            viewHolder.couponImage=(ImageView)view.findViewById(R.id.coupon_image);
            viewHolder.userImage=(ImageView)view.findViewById(R.id.user_image);
            viewHolder.status=(Button)view.findViewById(R.id.status);
            viewHolder.contact=(Button)view.findViewById(R.id.contact);
            view.setTag(viewHolder);
        }else {
            Clog.d("testListview",itemList.size()+" "+positon+"no null");
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
        final Trade trade=itemList.get(positon);
        viewHolder.nickname.setText(trade.getNickname());
        viewHolder.desc.setText(trade.getDesc());
        viewHolder.price.setText(trade.getPrice()+"");
        String couponImgUrl=trade.getCouponImageUrl();
        String userImgUrl=trade.getUserImageUrl();
        ImageUtil.displayMyImage(couponImgUrl,viewHolder.couponImage);
        ImageUtil.displayMyImage(userImgUrl, viewHolder.userImage);
        viewHolder.contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.KToast(context, "not ready");

            }
        });
        final int state=trade.getTradeState();
        switch (state){
            case 0:viewHolder.status.setText(R.string.status_orderd_button);
            break;
            default:break;
        }
        viewHolder.status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (state){
                    case 0:ToastUtil.KToast(context,"not ready");
                        break;
                    default:ToastUtil.KToast(context,"not ready");
                }
            }
        });
        return view;
    }
    private class ViewHolder{
        TextView nickname;
        TextView desc;
        TextView price;
        ImageView couponImage;
        ImageView userImage;
        Button contact;
        Button status;

    }
}
