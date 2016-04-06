package com.woyeyo.woyeyo.model;
import android.graphics.Bitmap;

import com.woyeyo.woyeyo.bean.User;
import com.woyeyo.woyeyo.presenter.OnGetUserInfoListener;
import com.woyeyo.woyeyo.presenter.OnSendInfoListener;
import com.woyeyo.woyeyo.utils.Clog;
import com.woyeyo.woyeyo.utils.Token;


/**
 * Created by fam_000 on 2016/3/15.
 */
public class GetUserInfo implements IGetUserInfo {
    private User user=new User();
    public void getUserInfo(final String token,final OnGetUserInfoListener listener){
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
                    user.setCommentNum(6);
                    user.setGender("male");
                    user.setImageUrl("http://cdn.duitang.com/uploads/item/201505/03/20150503170953_5MS8s.png");
                    user.setNickName("John");
                    user.setPersonId(1120141111);
                    user.setStarNum(5);

                    listener.getInfoSuccess(user);
                }
                else {
                    listener.getInfoFailed();
                }
            }
        }.start();
    }
    @Override
    public void getSellerInfo(String token,final OnGetUserInfoListener listener){
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
                    user.setCommentNum(10);
                    user.setGender("female");
                    user.setImageUrl("http://cdn.duitang.com/uploads/item/201505/03/20150503170953_5MS8s.png");
                    user.setNickName("Tony");
                    user.setPersonId(1120141132);
                    user.setStarNum(5);
                    user.setDealNum(7);

                    listener.getInfoSuccess(user);
                }
                else {
                    listener.getInfoFailed();
                }
            }
        }.start();

    }
    public void changeUserSex(final boolean isMan,final OnSendInfoListener listener){
        String token= Token.getToken();
        new Thread(){
            @Override
            public void run(){
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if(true){

                   if(isMan){
                       Clog.d("change to man");
                   }else{
                       Clog.d("change to woman");
                   }

                    listener.sendInfoSuccess();
                }
                else {
                    listener.sendInfoFailed();
                }
            }
        }.start();

    }
    public void changeUserPhoto(Bitmap bitmap,final OnSendInfoListener listener){
        String token= Token.getToken();
        new Thread(){
            @Override
            public void run(){
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if(true){



                    listener.sendInfoSuccess();
                }
                else {
                    listener.sendInfoFailed();
                }
            }
        }.start();
    }
}
