package com.woyeyo.woyeyo.model;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.bean.TradeInfo;
import com.woyeyo.woyeyo.presenter.OnTradeInfoListener;
import com.woyeyo.woyeyo.utils.BitmapResource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fam_000 on 2016/2/24.
 */
public class GetTradeInfo implements GetTrade{
    public void getTradeInfo(final String tradeName,final OnTradeInfoListener listener ){
        new Thread(){
            @Override
            public void run(){
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if(true){
                    //TODO judge if get proper info
                    List<TradeInfo> list=new ArrayList<TradeInfo>();
                    for(int i=0;i<10;i++){
                        TradeInfo tradeInfo=new TradeInfo();
                        tradeInfo.setDescription("好的东西" + i);
                        tradeInfo.setPhoto(BitmapResource.getBitmapFromResource(R.drawable.userimage));
                        list.add(tradeInfo);
                    }
                    listener.getTradeInfoSuccess(list);
                }
                else {
                    listener.getTradeInfoFailed();
                }
            }
        }.start();
    }

}
