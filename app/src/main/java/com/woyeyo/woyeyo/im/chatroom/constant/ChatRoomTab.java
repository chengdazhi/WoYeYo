package com.woyeyo.woyeyo.im.chatroom.constant;


import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.im.chatroom.fragment.tab.ChatRoomTabFragment;
import com.woyeyo.woyeyo.im.chatroom.fragment.tab.MasterTabFragment;
import com.woyeyo.woyeyo.im.chatroom.fragment.tab.MessageTabFragment;
import com.woyeyo.woyeyo.im.chatroom.fragment.tab.OnlinePeopleTabFragment;

/**
 * Created by hzxuwen on 2015/12/14.
 */
public enum ChatRoomTab {
    CHAT_ROOM_MESSAGE(0, MessageTabFragment.class, R.string.chat_room_message, R.layout.chat_room_message_tab),
    MASTER(1, MasterTabFragment.class, R.string.chat_room_master, R.layout.chat_room_master_tab),
    ONLINE_PEOPLE(2, OnlinePeopleTabFragment.class, R.string.chat_room_online_people, R.layout.chat_room_people_tab);

    public final int tabIndex;

    public final Class<? extends ChatRoomTabFragment> clazz;

    public final int resId;

    public final int fragmentId;

    public final int layoutId;

    ChatRoomTab(int index, Class<? extends ChatRoomTabFragment> clazz, int resId, int layoutId) {
        this.tabIndex = index;
        this.clazz = clazz;
        this.resId = resId;
        this.fragmentId = index;
        this.layoutId = layoutId;
    }

    public static final ChatRoomTab fromTabIndex(int tabIndex) {
        for (ChatRoomTab value : ChatRoomTab.values()) {
            if (value.tabIndex == tabIndex) {
                return value;
            }
        }

        return null;
    }
}