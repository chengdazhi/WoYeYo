package com.woyeyo.woyeyo.im.main.fragment;


import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.im.chatroom.fragment.ChatRoomsFragment;
import com.woyeyo.woyeyo.im.main.model.MainTab;

/**
 * 聊天室主TAB页
 * Created by huangjun on 2015/12/11.
 */
public class ChatRoomListFragment extends MainTabFragment {
    private ChatRoomsFragment fragment;
    public ChatRoomListFragment() {
        setContainerId(MainTab.CHAT_ROOM.fragmentId);
    }

    @Override
    protected void onInit() {
        // 采用静态集成，这里不需要做什么了
        fragment = (ChatRoomsFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.chat_rooms_fragment);
    }

    @Override
    public void onCurrent() {
        super.onCurrent();
        if (fragment != null) {
            fragment.onCurrent();
        }
    }
}
