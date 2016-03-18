package com.woyeyo.woyeyo.ui.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.TextView;

import com.mikepenz.materialdrawer.Drawer;
import com.woyeyo.woyeyo.R;

/**
 * Created by DongBaishun on 2016/3 /4.
 */


public class AboutActivity extends KBaseActivity {

    public void setResId() {
        mainResId = R.layout.activity_about;
    }

    public void setToolBarTitle() {
        title = R.string.about_title;
    }
    public void initSpecialView(){
        //TODO:get view from resource xml

    }

}


