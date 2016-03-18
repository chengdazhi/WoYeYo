package com.woyeyo.woyeyo.model;

import com.woyeyo.woyeyo.bean.PublishInfo;
import com.woyeyo.woyeyo.presenter.OnSendInfoListener;

/**
 * Created by fam_000 on 2016/3/18.
 */
public interface ISendPublish {
    void sendBuyPublish(PublishInfo publishInfo,OnSendInfoListener listener);
    void sendSellPublish(PublishInfo publishInfo,OnSendInfoListener listener);
}
