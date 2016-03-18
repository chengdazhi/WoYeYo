package com.woyeyo.woyeyo.model;
import com.woyeyo.woyeyo.bean.User;
import com.woyeyo.woyeyo.presenter.OnGetUserInfoListener;


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
}
