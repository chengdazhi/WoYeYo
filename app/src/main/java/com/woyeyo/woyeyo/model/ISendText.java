package com.woyeyo.woyeyo.model;

import com.woyeyo.woyeyo.presenter.OnSendInfoListener;

/**
 * Created by fam_000 on 2016/3/13.
 */
public interface ISendText {
    void sendAccusation(String accusation,String contact,OnSendInfoListener listener);
    void sendFeedBack(String feedback,String contact,OnSendInfoListener listener);
}
