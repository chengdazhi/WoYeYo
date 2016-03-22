package com.woyeyo.woyeyo.im.main.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.netease.nim.uikit.common.activity.TActionBarActivity;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.auth.AuthService;
import com.netease.nimlib.sdk.auth.ClientType;
import com.netease.nimlib.sdk.auth.OnlineClient;
import com.woyeyo.woyeyo.R;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hzxuwen on 2015/7/8.
 */
public class MultiportActivity extends TActionBarActivity {
    private final static String EXTRA_DATA = "EXTRA_DATA";

    private LinearLayout versionLayout;

    private List<OnlineClient> onlineClients;

    private int count = 0;

    public static void startActivity(Context context, List<OnlineClient> onlineClients) {
        Intent intent = new Intent();
        intent.setClass(context, MultiportActivity.class);
        intent.putExtra(EXTRA_DATA, (Serializable) onlineClients);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiport_activity);
        setTitle(R.string.multiport_manager);

        findViews();
        parseIntent();
        updateView();
    }

    private void findViews() {
        versionLayout = findView(R.id.versions);
    }


    private void parseIntent() {
        onlineClients = (List<OnlineClient>)getIntent().getSerializableExtra(EXTRA_DATA);
        count = onlineClients.size();
    }

    private void updateView() {
        for(OnlineClient client : onlineClients) {
            TextView clientName = initVersionView(client);
            switch (client.getClientType()) {
                case ClientType.Windows:
                    clientName.setText(R.string.computer_version);
                    break;
                case ClientType.Web:
                    clientName.setText(R.string.web_version);
                    break;
                case ClientType.Android:
                case ClientType.iOS:
                    clientName.setText(R.string.mobile_version);
                    break;
                default:
                    break;
            }
        }
    }

    private TextView initVersionView(OnlineClient client) {
        final OnlineClient c = client;
        final View view = getLayoutInflater().inflate(R.layout.multiport_item, null);
        versionLayout.addView(view);
        TextView clientName = (TextView) view.findViewById(R.id.client_name);
        TextView clientLogout = (TextView) view.findViewById(R.id.client_logout);
        clientLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kickOtherOut(c, view, count--);
            }
        });
        return clientName;
    }

    private void kickOtherOut(OnlineClient client, final View layout, final int finished) {
        NIMClient.getService(AuthService.class).kickOtherClient(client).setCallback(new RequestCallback<Void>() {
            @Override
            public void onSuccess(Void param) {
                hideLayout(layout, finished);
            }

            @Override
            public void onFailed(int code) {

            }

            @Override
            public void onException(Throwable exception) {

            }
        });
    }

    private void hideLayout(View layout, int finished) {
        layout.setVisibility(View.GONE);
        if(finished == 1) {
            finish();
        }
    }
}
