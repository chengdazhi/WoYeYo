package com.woyeyo.woyeyo.ui.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.mikepenz.materialdrawer.Drawer;
import com.woyeyo.woyeyo.R;

public class GuaranteeInstructionActivity extends KBaseActivity {

    public void setResId() {
        mainResId = R.layout.activity_guarantee_instruction;
        toolbarResId = R.id.test_main_page_toolbar;
    }

    public void setToolBarTitle() {
        title = R.string.guarantee_title;
    }

}
