package com.woyeyo.woyeyo.ui.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.TextView;

import com.mikepenz.materialdrawer.Drawer;
import com.woyeyo.woyeyo.R;

/**
 * Created by DongBaishun on 2016/3/4.
 */
public class AccusationActivity extends KBaseActivity {
    private Drawer result;

    public void setResId() {
        mainResId = R.layout.activity_accusation;
        toolbarResId = R.id.test_main_page_toolbar;
    }

    public void setToolBarTitle() {
        title = R.string.accusation_title;
    }

}
