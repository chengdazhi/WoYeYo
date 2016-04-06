package com.woyeyo.woyeyo.presenter;

import android.os.Handler;

import com.woyeyo.woyeyo.model.ISendText;
import com.woyeyo.woyeyo.model.SendText;
import com.woyeyo.woyeyo.view.ISendInfoView;

/**
 * Created by fam_000 on 2016/3/13.
 */
public class AccusationPresenter {
    private ISendText iSendText;
    private ISendInfoView iSendInfoView;
    private Handler mHandler=new Handler();
    public AccusationPresenter(ISendInfoView iSendInfoView){
        this.iSendInfoView=iSendInfoView;
        this.iSendText=new SendText();
    }
    public void sendAccsationtoServer(String accusation,String contact){
        iSendText.sendAccusation(accusation, contact, new OnSendInfoListener() {
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
