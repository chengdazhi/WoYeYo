package com.woyeyo.woyeyo.presenter;

import android.graphics.Bitmap;
import android.os.Handler;

import com.woyeyo.woyeyo.bean.User;
import com.woyeyo.woyeyo.model.GetUserInfo;
import com.woyeyo.woyeyo.model.IGetUserInfo;
import com.woyeyo.woyeyo.view.IUserInfoView;

/**
 * Created by fam_000 on 2016/3/15.
 */
public class UserInfoPresenter {
    private IUserInfoView iUserInfoView;
    private IGetUserInfo iGetUserInfo;
    private Handler mHandler=new Handler();
    public UserInfoPresenter(IUserInfoView iUserInfoView){
        this.iUserInfoView=iUserInfoView;
        this.iGetUserInfo=new GetUserInfo();
    }
    public void getUserInfofromServer(String token){
        iGetUserInfo.getUserInfo(token, new OnGetUserInfoListener() {
            @Override
            public void getInfoSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserInfoView.showUserInfo(user);
                    }
                });
            }

            @Override
            public void getInfoFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserInfoView.showError();
                    }
                });
            }
        });
    }
    public void getSellerInfofromServer(String token){
        iGetUserInfo.getSellerInfo(token, new OnGetUserInfoListener() {
            @Override
            public void getInfoSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserInfoView.showUserInfo(user);
                    }
                });
            }

            @Override
            public void getInfoFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserInfoView.showError();
                    }
                });
            }
        });
    }
    public void changeSex(boolean isMan){
        iGetUserInfo.changeUserSex(isMan, new OnSendInfoListener() {
            @Override
            public void sendInfoSuccess() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserInfoView.showChangeSucc();
                    }
                });
            }

            @Override
            public void sendInfoFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserInfoView.showChangeFail();
                    }
                });
            }
        });
    }
    public void changePhoto(Bitmap bitmap){
        iGetUserInfo.changeUserPhoto(bitmap, new OnSendInfoListener() {
            @Override
            public void sendInfoSuccess() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserInfoView.showChangeSucc();
                    }
                });
            }

            @Override
            public void sendInfoFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserInfoView.showChangeFail();
                    }
                });
            }
        });
    }


}
