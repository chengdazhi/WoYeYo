package com.woyeyo.woyeyo.model;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.bean.TradeInfo;
import com.woyeyo.woyeyo.presenter.OnInfoListener;
import com.woyeyo.woyeyo.presenter.OnSendInfoListener;
import com.woyeyo.woyeyo.utils.BitmapResource;
import com.woyeyo.woyeyo.utils.Clog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by fam_000 on 2016/3/13.
 */
public class SendText implements ISendText {
    public void sendAccusation(String content,String contact, final OnSendInfoListener listener){
        new Thread(){
            @Override
            public void run(){
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if(true) {
                    //TODO add send accusation action
                    listener.sendInfoSuccess();
                }
                else {
                    listener.sendInfoFailed();
                }
            }
        }.start();
    }
    public void sendFeedBack(String content,String contact,final OnSendInfoListener listener){
        new Thread(){
            @Override
            public void run(){
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if(true) {
                    //TODO add send feedback action
                    listener.sendInfoSuccess();
                }
                else {
                    listener.sendInfoFailed();
                }
            }
        }.start();
    }
    public void sendComment(final String comment, final float rating,final OnSendInfoListener listener){
        new Thread(){
            @Override
            public void run(){
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if(true) {
                    Clog.d("comment:"+comment+" rating:"+rating);
                    //TODO add send feedback action
                    listener.sendInfoSuccess();
                }
                else {
                    listener.sendInfoFailed();
                }
            }
        }.start();
    }
}
