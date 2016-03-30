package com.woyeyo.woyeyo.im.session.action;

import com.netease.nim.uikit.session.actions.BaseAction;
import com.netease.nimlib.sdk.msg.MessageBuilder;
import com.netease.nimlib.sdk.msg.model.CustomMessageConfig;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.woyeyo.woyeyo.R;

import java.util.HashMap;

/**
 * Tip类型消息测试
 * Created by hzxuwen on 2016/3/9.
 */
public class TipAction extends BaseAction {

    public TipAction() {
        super(R.drawable.message_plus_tip_selector, R.string.input_panel_tip);
    }
    @Override
    public void onClick() {
        //此处强行传入空map，可能非法
        IMMessage msg = MessageBuilder.createTipMessage(getAccount(), getSessionType(), new HashMap<String, Object>());
        msg.setContent("一条Tip测试消息");

        CustomMessageConfig config = new CustomMessageConfig();
        config.enablePush = false; // 不推送
        msg.setConfig(config);

        sendMessage(msg);
    }
}
