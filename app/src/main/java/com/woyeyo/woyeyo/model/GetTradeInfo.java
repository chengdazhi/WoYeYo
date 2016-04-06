package com.woyeyo.woyeyo.model;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.bean.Trade;
import com.woyeyo.woyeyo.bean.TradeInfo;
import com.woyeyo.woyeyo.presenter.OnInfoListener;
import com.woyeyo.woyeyo.utils.BitmapResource;
import com.woyeyo.woyeyo.utils.Token;
import com.woyeyo.woyeyo.utils.UrlConstants;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by fam_000 on 2016/2/24.
 */
public class GetTradeInfo implements GetTrade{
    @Override
    public void getTradeInfo(final long tradeId,final int itemCount,final OnInfoListener listener ){
        new Thread(){
            @Override
            public void run(){
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if(true){
                    //TODO judge if get proper info
                    List<TradeInfo> list=new ArrayList<TradeInfo>();
                    for(int i=0;i<10;i++){
                        TradeInfo tradeInfo=new TradeInfo();

                        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss ");
                        Date curDate=new Date(System.currentTimeMillis()+itemCount*1000);

                        tradeInfo.setDescription("好东西" +formatter.format(curDate) );
                        tradeInfo.setPhoto(BitmapResource.getBitmapFromResource(R.drawable.userimage));
                        tradeInfo.setStarNum(i%5);
                        tradeInfo.setPersonId(123312313+i);
                        tradeInfo.setSquareId(tradeId);
                        list.add(tradeInfo);
                    }
                    listener.getInfoSuccess(list);
                }
                else {
                    listener.getInfoFailed();
                }
            }
        }.start();
    }
    public void getTradeHistory(final int itemCount,final OnInfoListener listener){
        new Thread(){
            @Override
            public void run(){
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if(true){
                    //TODO judge if get proper info
                    String token= Token.getToken();
                    //TODO:get token
                    List<Trade> list=new ArrayList<Trade>();
                    for(int i=1;i<=5;i++){
                        int j=i+itemCount;
                        Trade trade=new Trade();
                        trade.setCouponImageUrl(UrlConstants.imgs[j%6]);
                        trade.setDesc("fortest"+j);
                        trade.setNickname("Neo"+j);
                        trade.setPrice(j);
                        trade.setTradeState(0);
                        trade.setUserImageUrl(UrlConstants.userImg);
                        list.add(trade);
                    }
                    listener.getInfoSuccess(list);
                }
                else {
                    listener.getInfoFailed();
                }
            }
        }.start();
    }
}
