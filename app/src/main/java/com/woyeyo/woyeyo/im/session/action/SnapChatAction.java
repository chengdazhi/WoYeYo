package com.woyeyo.woyeyo.im.session.action;

import com.netease.nim.uikit.session.actions.PickImageAction;
import com.netease.nimlib.sdk.msg.MessageBuilder;
import com.netease.nimlib.sdk.msg.model.CustomMessageConfig;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.im.session.extension.SnapChatAttachment;

import java.io.File;

/**
 * Created by zhoujianghua on 2015/7/31.
 */
public class SnapChatAction extends PickImageAction {

    public SnapChatAction() {
        super(R.drawable.message_plus_snapchat_selector, R.string.input_panel_snapchat, false);
    }

    @Override
    protected void onPicked(File file) {
        SnapChatAttachment snapChatAttachment = new SnapChatAttachment();
        snapChatAttachment.setPath(file.getPath());
        snapChatAttachment.setSize(file.length());
        CustomMessageConfig config = new CustomMessageConfig();
        config.enableHistory = false;
        config.enableRoaming = false;
        config.enableSelfSync = false;
        IMMessage stickerMessage = MessageBuilder.createCustomMessage(getAccount(), getSessionType(), "阅后即焚消息", snapChatAttachment, config);
        sendMessage(stickerMessage);
    }

}
