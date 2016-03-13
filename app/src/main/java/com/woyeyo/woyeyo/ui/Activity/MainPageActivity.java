package com.woyeyo.woyeyo.ui.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.ui.fragment.TestScrollViewFragment;

public class MainPageActivity extends AppCompatActivity {
    private TestScrollViewFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

    }
}
