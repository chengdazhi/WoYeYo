package com.woyeyo.woyeyo.ui.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.woyeyo.woyeyo.R;

public class UserInfoActivity extends AppCompatActivity {

    ///标题栏
    private TextView titleText;
    private ImageButton titleImageBack;
    private ImageButton titleImageShare;
    private ImageButton titleImageMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        InitTextTitle();
    }

    private void InitTextTitle() {
        titleText = (TextView) findViewById(R.id.titleText);
        titleText.setText("个人信息");
        titleImageBack = (ImageButton)this.findViewById(R.id.titleImgBack);
        titleImageBack.setImageDrawable(getResources().getDrawable(R.drawable.back_icon));
        titleImageMessage = (ImageButton)this.findViewById(R.id.titleImgMessage);
        titleImageMessage.setImageDrawable(getResources().getDrawable(R.drawable.message));
    }
}
