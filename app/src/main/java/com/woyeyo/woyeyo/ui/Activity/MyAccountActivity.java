package com.woyeyo.woyeyo.ui.Activity;

import android.os.Bundle;

import com.woyeyo.woyeyo.R;

/**
 * Created by DongBaishun on 2016/4/3.
 */
public class MyAccountActivity extends KBaseActivity{
    public void setResId() {
        mainResId = R.layout.activity_my_account;
        toolbarResId = R.id.test_main_page_toolbar;
    }

    public void setToolBarTitle() {
        title = R.string.account_title;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

    }

}
