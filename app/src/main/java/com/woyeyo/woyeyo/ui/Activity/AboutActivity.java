package com.woyeyo.woyeyo.ui.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.TextView;

import com.woyeyo.woyeyo.R;

/**
 * Created by DongBaishun on 2016/3 /4.
 */


public class AboutActivity extends AppCompatActivity{

    ///标题栏
    private TextView titleText;
    private ImageButton titleImageBack;
    private ImageButton titleImageShare;
    private ImageButton titleImageMessage;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        InitTextTitle();
    }

    private void InitTextTitle(){
        titleText = (TextView) findViewById(R.id.titleText);
        titleText.setText("关于我们");
        titleImageBack = (ImageButton)this.findViewById(R.id.titleImgBack);
        titleImageBack.setImageDrawable(getResources().getDrawable(R.drawable.back_icon));
        titleImageMessage = (ImageButton)this.findViewById(R.id.titleImgMessage);
        titleImageMessage.setImageDrawable(getResources().getDrawable(R.drawable.message));
    }

}


