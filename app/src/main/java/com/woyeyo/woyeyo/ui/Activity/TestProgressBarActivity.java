package com.woyeyo.woyeyo.ui.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.ui.CustomUi.CustomCircle;

/**
 * Created by fam_000 on 2016/5/1.
 */
public class TestProgressBarActivity extends AppCompatActivity{
    private CustomCircle customCircle;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_progress_bar);

    }
    @Override
    protected void onResume(){
        super.onResume();
        init();
    }

    private void init() {
        customCircle = (CustomCircle) findViewById(R.id.customCircle);
        float now=200.5f;
        float future=50.5f;
        customCircle.setMoney(now, future);

    }
}
