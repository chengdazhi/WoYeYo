package com.woyeyo.woyeyo.ui.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;
import android.widget.TextView;

import com.mikepenz.materialdrawer.Drawer;
import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.ui.Activity.KBaseActivity;

public class SettingActivity extends KBaseActivity {
    private Drawer result;
    public void setResId(){
        mainResId= R.layout.activity_setting;
        toolbarResId=R.id.test_main_page_toolbar;
    }
    public void setToolBarTitle(){
        title=R.string.setting_title;
    }

}
