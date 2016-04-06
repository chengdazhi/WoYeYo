package com.woyeyo.woyeyo.model;

import com.woyeyo.woyeyo.bean.PublishInfo;
import com.woyeyo.woyeyo.presenter.OnSendInfoListener;
import com.woyeyo.woyeyo.view.ISendInfoView;

/**
 * Created by fam_000 on 2016/3/18.
 */
public class SendPublish implements ISendPublish {
    @Override
    public void sendBuyPublish(final PublishInfo publishInfo,final OnSendInfoListener listener){
        new Thread(){
            @Override
            public void run(){
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if(true) {
                    //TODO add send buyPublish action
                    listener.sendInfoSuccess();
                }
                else {
                    listener.sendInfoFailed();
                }
            }
        }.start();
    }
    @Override
    public void sendSellPublish(final PublishInfo publishInfo,final OnSendInfoListener listener){
        new Thread(){
            @Override
            public void run(){
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if(true) {
                    //TODO add send SellPublish action
                    listener.sendInfoSuccess();
                }
                else {
                    listener.sendInfoFailed();
                }
            }
        }.start();
    }
}
