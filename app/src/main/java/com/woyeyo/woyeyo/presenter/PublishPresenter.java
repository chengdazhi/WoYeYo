package com.woyeyo.woyeyo.presenter;

import android.os.Handler;

import com.woyeyo.woyeyo.bean.PublishInfo;
import com.woyeyo.woyeyo.model.ISendPublish;
import com.woyeyo.woyeyo.model.SendPublish;
import com.woyeyo.woyeyo.view.ISendInfoView;

/**
 * Created by fam_000 on 2016/3/18.
 */
public class PublishPresenter {
    private ISendInfoView iSendInfoView;
    private ISendPublish iSendPublish;
    private Handler mHandler=new Handler();
    public PublishPresenter(ISendInfoView iSendInfoView){
        this.iSendInfoView=iSendInfoView;
        iSendPublish=new SendPublish();
    }
    public void sendPublish(PublishInfo publishInfo){
        if(publishInfo.isBuy()){
            iSendPublish.sendBuyPublish(publishInfo, new OnSendInfoListener() {
                @Override
                public void sendInfoSuccess() {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            iSendInfoView.showSendSuccess();
                        }
                    });

                }

                @Override
                public void sendInfoFailed() {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            iSendInfoView.showSendError();
                        }
                    });
                }
            });
        }
        else{
            iSendPublish.sendSellPublish(publishInfo, new OnSendInfoListener() {
                @Override
                public void sendInfoSuccess() {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            iSendInfoView.showSendSuccess();
                        }
                    });

                }

                @Override
                public void sendInfoFailed() {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            iSendInfoView.showSendError();
                        }
                    });
                }
            });
        }


    }
}
